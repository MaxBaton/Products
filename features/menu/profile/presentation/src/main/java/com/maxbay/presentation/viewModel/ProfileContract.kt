package com.maxbay.presentation.viewModel

import com.maxbay.productsTestEffectiveMobile.models.User
import com.maxbay.productsTestEffectiveMobile.mvi.UnidirectionalViewModel

interface ProfileContract: UnidirectionalViewModel<
            ProfileContract.State,
            ProfileContract.Event,
            ProfileContract.Effect
        > {
    sealed interface State {
        data object Loading: State
        data object Fail: State
        data class Success(val user: User): State
    }

    sealed interface Event {
        data class SignOut(val userId: Int): Event
    }

    sealed interface Effect {
        data object None: Effect
        data object SignOut: Effect
    }
}