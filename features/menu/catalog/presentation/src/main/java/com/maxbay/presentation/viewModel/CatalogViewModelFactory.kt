package com.maxbay.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.maxbay.domain.usecase.ObserveProductsUseCase

@Suppress("UNCHECKED_CAST")
class CatalogViewModelFactory(
    private val observeProductsUseCase: ObserveProductsUseCase
): ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CatalogViewModel(observeProductsUseCase = observeProductsUseCase) as T
    }
}