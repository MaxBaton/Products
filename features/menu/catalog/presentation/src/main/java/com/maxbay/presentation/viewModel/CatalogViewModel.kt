package com.maxbay.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maxbay.domain.models.Product
import com.maxbay.domain.models.SortOrder
import com.maxbay.domain.usecase.ChangeFavoriteStatusUseCase
import com.maxbay.domain.usecase.FilterAllProductsUseCase
import com.maxbay.domain.usecase.FilterProductsByTagUseCase
import com.maxbay.domain.usecase.ObserveProductsUseCase
import com.maxbay.domain.usecase.SortProductsUseCase
import com.maxbay.presentation.mappers.toUi
import com.maxbay.presentation.models.SortOrderUi
import com.maxbay.presentation.models.TAG_ALL
import com.maxbay.presentation.models.sortOrdersUi
import com.maxbay.presentation.utils.toTagsUi
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

private const val ALL_TAGS_INDEX = 0
private const val UNSELECTED_TAG_INDEX = -1
private val defaultSort = SortOrder.POPULAR

class CatalogViewModel(
    private val observeProductsUseCase: ObserveProductsUseCase,
    private val filterProductsByTagUseCase: FilterProductsByTagUseCase,
    private val filterAllProductsUseCase: FilterAllProductsUseCase,
    private val changeFavoriteStatusUseCase: ChangeFavoriteStatusUseCase,
    private val sortProductsUseCase: SortProductsUseCase
): ViewModel(), CatalogContract {
    private val _uiState = MutableStateFlow<CatalogContract.State>(CatalogContract.State.Loading)
    override val uiState: StateFlow<CatalogContract.State> = _uiState.asStateFlow()

    private val _effect = MutableStateFlow<CatalogContract.Effect>(CatalogContract.Effect.None)
    override val effect: StateFlow<CatalogContract.Effect> = _effect.asStateFlow()

    init {
        observeProducts()
    }

    override fun handleEvent(event: CatalogContract.Event) {
        when(event) {
            is CatalogContract.Event.ChangeFavoriteStatus -> changeFavoriteStatus(
                productId = event.productId,
                isFavorite = event.isFavorite
            )
            is CatalogContract.Event.TagItemClick -> onTagItemClick(tag = event.tag)
            is CatalogContract.Event.ClearTagItemClick -> onClearTagItem()
            is CatalogContract.Event.SortItemClick -> onSortClick(sortCode = event.sortCode)
        }
    }

    override fun consume() {
        _effect.update {
            CatalogContract.Effect.None
        }
    }

    private fun observeProducts() {
        val exceptionHandler = CoroutineExceptionHandler { _, _ ->
            _uiState.update {
                CatalogContract.State.Fail
            }
        }

        viewModelScope.launch(exceptionHandler) {
            observeProductsUseCase.execute().collect { products ->
                _uiState.update { currentState ->
                    val (tags, selectedIndex, selectedSortIndex) = if (currentState is CatalogContract.State.Success) {
                        Triple(currentState.tags, currentState.selectedTagIndex, currentState.selectedSortIndex)
                    }else {
                        Triple(getAllTags(products).toTagsUi().toImmutableList(), ALL_TAGS_INDEX, defaultSort.ordinal)
                    }

                    CatalogContract.State.Success(
                        products = products.toUi(),
                        tags = tags,
                        selectedTagIndex = selectedIndex,
                        sortOrders = getAllSortOrdersUi(),
                        selectedSortIndex = selectedSortIndex
                    )
                }
            }
        }
    }

    private fun changeFavoriteStatus(productId: String, isFavorite: Boolean) {
        viewModelScope.launch {
            changeFavoriteStatusUseCase.execute(
                productId = productId,
                isFavorite = isFavorite
            )
        }
    }

    private fun onTagItemClick(tag: String) {
        viewModelScope.launch {
            if (_uiState.value is CatalogContract.State.Success) {
                val currentState = _uiState.value as CatalogContract.State.Success
                val currentTags = currentState.tags
                val itemByTitle = currentTags.firstOrNull { it.tagServer == tag }
                val tagIndex = itemByTitle?.let { currentTags.indexOf(it) } ?: ALL_TAGS_INDEX

                if (tagIndex == ALL_TAGS_INDEX) {
                    filterAllProductsUseCase.execute()
                }else {
                    filterProductsByTagUseCase.execute(tag = tag)
                }

                _uiState.update {
                    currentState.copy(selectedTagIndex = tagIndex)
                }
            }
        }
    }

    private fun onClearTagItem() {
        viewModelScope.launch {
            if (_uiState.value is CatalogContract.State.Success) {
                val currentState = _uiState.value as CatalogContract.State.Success

                filterAllProductsUseCase.execute()

                _uiState.update {
                    currentState.copy(selectedTagIndex = UNSELECTED_TAG_INDEX)
                }
            }
        }
    }

    private fun getAllTags(products: List<Product>): List<String> {
        val tags = mutableSetOf<String>()

        tags.add(TAG_ALL)

        products.forEach { product ->
            product.tags.forEach { tag ->
                tags.add(tag)
            }
        }

        return tags.toList()
    }

    private fun getAllSortOrdersUi(): ImmutableList<SortOrderUi> {
        val ordersUi = mutableListOf<SortOrderUi>()

        SortOrder.entries.forEach { order ->
            val titleId = sortOrdersUi.getOrDefault(order.ordinal, -1)
            if (titleId != -1) {
                ordersUi.add(
                    SortOrderUi(sortCode = order.ordinal, titleId = titleId)
                )
            }
        }

        return ordersUi.toImmutableList()
    }

    private fun onSortClick(sortCode: Int) {
        viewModelScope.launch {
            if (_uiState.value is CatalogContract.State.Success) {
                sortProductsUseCase.execute(sortCode = sortCode)

                val currentState = _uiState.value as CatalogContract.State.Success
                _uiState.update {
                    currentState.copy(selectedSortIndex = sortCode)
                }
            }
        }
    }
}