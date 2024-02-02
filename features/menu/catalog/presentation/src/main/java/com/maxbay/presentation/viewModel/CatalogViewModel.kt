package com.maxbay.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maxbay.domain.usecase.ObserveProductsUseCase
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CatalogViewModel(
    private val observeProductsUseCase: ObserveProductsUseCase
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
            is CatalogContract.Event.AddToFavorite -> {}
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

        viewModelScope.launch {
            observeProductsUseCase.execute().collect { products ->
                _uiState.update {
                    CatalogContract.State.Success(products = products)
                }
            }
        }
    }
}