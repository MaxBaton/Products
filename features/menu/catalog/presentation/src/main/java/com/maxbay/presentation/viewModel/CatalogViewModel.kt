package com.maxbay.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maxbay.domain.models.Product
import com.maxbay.domain.usecase.FilterAllProductsUseCase
import com.maxbay.domain.usecase.FilterProductsByTagUseCase
import com.maxbay.domain.usecase.ObserveProductsUseCase
import com.maxbay.presentation.mappers.toUi
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

private const val ALL_TAGS_INDEX = 0
private const val UNSELECTED_TAG_INDEX = -1
private const val EMPTY = ""

class CatalogViewModel(
    private val observeProductsUseCase: ObserveProductsUseCase,
    private val filterProductsByTagUseCase: FilterProductsByTagUseCase,
    private val filterAllProductsUseCase: FilterAllProductsUseCase
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
            is CatalogContract.Event.AddToFavorite -> addToFavorite(productId = event.productId)
            is CatalogContract.Event.TagItemClick -> onTagItemClick(tag = event.tag)
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
                    val (tags, selectedIndex) = if (currentState is CatalogContract.State.Success) {
                        currentState.tags to currentState.selectedTagIndex
                    }else {
                        getAllTags(products = products).toImmutableList() to ALL_TAGS_INDEX
                    }

                    CatalogContract.State.Success(
                        products = products.toUi(),
                        tags = tags,
                        selectedTagIndex = selectedIndex
                    )
                }
            }
        }
    }

    private fun addToFavorite(productId: String) {
        //
    }

    private fun onTagItemClick(tag: String) {
        viewModelScope.launch {
            if (_uiState.value is CatalogContract.State.Success) {
                val currentState = _uiState.value as CatalogContract.State.Success
                val currentTags = currentState.tags
                val itemByTitle = currentTags.firstOrNull { it == tag }
                val tagIndex = itemByTitle?.let { currentTags.indexOf(it) } ?: ALL_TAGS_INDEX
                val (selectedTitle, selectedIndex) = if (tagIndex == currentState.selectedTagIndex) {
                    EMPTY to UNSELECTED_TAG_INDEX
                }else {
                    tag to tagIndex
                }

                if (selectedIndex == ALL_TAGS_INDEX) {
                    filterAllProductsUseCase.execute()
                }else {
                    filterProductsByTagUseCase.execute(tag = selectedTitle)
                }

                _uiState.update {
                    CatalogContract.State.Success(
                        tags = currentState.tags,
                        products = currentState.products,
                        selectedTagIndex = selectedIndex
                    )
                }

                /*_uiState.update {
                    CatalogContract.State.Success(
                        tags = currentState.tags,
                        products = emptyList<ProductUi>().toImmutableList(),
                        selectedTagIndex = selectedIndex
                    )
                }*/
            }
        }
    }

    private fun getAllTags(products: List<Product>): Set<String> {
        val tags = mutableSetOf<String>()

        tags.add("all")

        products.forEach { product ->
            product.tags.forEach { tag ->
                tags.add(tag)
            }
        }

        return tags
    }
}