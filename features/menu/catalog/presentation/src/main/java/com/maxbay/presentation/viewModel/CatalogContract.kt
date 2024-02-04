package com.maxbay.presentation.viewModel

import com.maxbay.presentation.models.ProductUi
import com.maxbay.presentation.models.TagUi
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
            val tags: ImmutableList<TagUi>,
            val selectedTagIndex: Int
        ): State
    }

    sealed interface Event {
        data class ChangeFavoriteStatus(val productId: String, val isFavorite: Boolean): Event
        data class TagItemClick(val tag: String): Event
        data object ClearTagItemClick: Event
    }

    sealed interface Effect {
        data object None: Effect
    }
}