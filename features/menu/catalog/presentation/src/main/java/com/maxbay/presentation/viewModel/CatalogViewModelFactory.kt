package com.maxbay.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.maxbay.domain.usecase.ChangeFavoriteStatusUseCase
import com.maxbay.domain.usecase.FilterAllProductsUseCase
import com.maxbay.domain.usecase.FilterProductsByTagUseCase
import com.maxbay.domain.usecase.ObserveProductsUseCase

@Suppress("UNCHECKED_CAST")
class CatalogViewModelFactory(
    private val observeProductsUseCase: ObserveProductsUseCase,
    private val filterProductsByTagUseCase: FilterProductsByTagUseCase,
    private val filterAllProductsUseCase: FilterAllProductsUseCase,
    private val changeFavoriteStatusUseCase: ChangeFavoriteStatusUseCase
): ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CatalogViewModel(
            observeProductsUseCase = observeProductsUseCase,
            filterProductsByTagUseCase = filterProductsByTagUseCase,
            filterAllProductsUseCase = filterAllProductsUseCase,
            changeFavoriteStatusUseCase = changeFavoriteStatusUseCase
        ) as T
    }
}