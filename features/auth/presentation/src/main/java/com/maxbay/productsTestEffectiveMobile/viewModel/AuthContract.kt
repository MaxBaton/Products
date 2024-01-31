package com.maxbay.productsTestEffectiveMobile.viewModel

import com.maxbay.productsTestEffectiveMobile.mvi.UnidirectionalViewModel

private const val EMPTY = ""

interface AuthContract: UnidirectionalViewModel<
        AuthContract.State,
        AuthContract.Event,
        AuthContract.Effect
        > {
    data class State(
        val firstName: String,
        val firstNameError: Boolean,
        val secondName: String,
        val secondNameError: Boolean,
        val mobilePhone: String,
        val mobilePhoneError: Boolean,
        val isCorrectInput: Boolean
    ) {
        companion object {
            fun initial(): State = State(
                firstName = EMPTY,
                firstNameError = false,
                secondName = EMPTY,
                secondNameError = false,
                mobilePhone = EMPTY,
                mobilePhoneError = false,
                isCorrectInput = false
            )
        }
    }

    sealed interface Event {
        data class FistNameChange(val firstName: String): Event
        data class SecondNameChange(val secondName: String): Event
        data class MobilePhoneChange(val mobilePhone: String): Event
        data object SignUp: Event
    }

    sealed interface Effect {
        data object None: Effect
        data object SignUp: Effect
    }
}