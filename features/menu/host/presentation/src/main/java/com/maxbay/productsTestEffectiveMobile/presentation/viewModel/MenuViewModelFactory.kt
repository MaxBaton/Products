package com.maxbay.productsTestEffectiveMobile.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.maxbay.productsTestEffectiveMobile.NavBottomMenuDestinationsCollection

@Suppress("UNCHECKED_CAST")
class MenuViewModelFactory(
    private val bottomMenuDestinationCollection: NavBottomMenuDestinationsCollection
): ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MenuViewModel(bottomMenuDestinationCollection = bottomMenuDestinationCollection) as T
    }
}