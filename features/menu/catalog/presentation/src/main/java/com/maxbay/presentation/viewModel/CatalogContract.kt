package com.maxbay.presentation.viewModel

import com.maxbay.presentation.models.ProductUi
import com.maxbay.productsTestEffectiveMobile.mvi.UnidirectionalViewModel
import kotlinx.collections.immutable.ImmutableList

interface CatalogContract: UnidirectionalViewModel<
            CatalogContract.State,
            CatalogContract.Event,
            CatalogContract.Effect
        > {
    sealed interface State {
        data object Loading: State
        data object Fail: State
        data class Success(
            val products: ImmutableList<ProductUi>,
            val tags: ImmutableList<String>,
            val selectedTagIndex: Int
        ): State
    }

    sealed interface Event {
        data class AddToFavorite(val productId: String): Event
        data class TagItemClick(val tag: String): Event
    }

    sealed interface Effect {
        data object None: Effect
    }
}