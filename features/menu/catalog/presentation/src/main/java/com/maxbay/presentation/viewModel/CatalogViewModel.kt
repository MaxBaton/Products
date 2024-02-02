package com.maxbay.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maxbay.domain.usecase.ObserveProductsUseCase
import kotlinx.coroutines.launch

class CatalogViewModel(
    private val observeProductsUseCase: ObserveProductsUseCase
): ViewModel() {
    init {
        viewModelScope.launch {
            observeProductsUseCase.execute()
        }
    }
}