package com.maxbay.presentation.viewModel

import com.maxbay.domain.models.Product
import com.maxbay.productsTestEffectiveMobile.mvi.UnidirectionalViewModel

interface CatalogContract: UnidirectionalViewModel<
            CatalogContract.State,
            CatalogContract.Event,
            CatalogContract.Effect
        > {
    sealed interface State {
        data object Loading: State
        data object Fail: State
        data class Success(val products: List<Product>): State
    }

    sealed interface Event {
        data class AddToFavorite(val idProduct: String): Event
    }

    sealed interface Effect {
        data object None: Effect
    }
}