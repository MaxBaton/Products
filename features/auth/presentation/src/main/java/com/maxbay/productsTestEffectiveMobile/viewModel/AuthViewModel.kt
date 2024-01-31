package com.maxbay.productsTestEffectiveMobile.viewModel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class AuthViewModel: ViewModel(), AuthContract {
    private val _uiState = MutableStateFlow(AuthContract.State.initial())
    override val uiState: StateFlow<AuthContract.State> = _uiState.asStateFlow()

    private val _effect = MutableStateFlow(AuthContract.Effect.None)
    override val effect: StateFlow<AuthContract.Effect> = _effect.asStateFlow()

    override fun handleEvent(event: AuthContract.Event) {
        when(event) {
            is AuthContract.Event.FistNameChange -> onFirstNameChange(firstName = event.firstName)
            is AuthContract.Event.SecondNameChange -> onSecondNameChange(secondName = event.secondName)
            is AuthContract.Event.MobilePhoneChange -> onMobilePhoneChange(mobilePhone = event.mobilePhone)
        }
    }

    override fun consume() {
        _effect.update {
            AuthContract.Effect.None
        }
    }

    private fun onFirstNameChange(firstName: String) {
        _uiState.update { currentState ->
            currentState.copy(
                firstName = firstName,
                firstNameError = false,
                isCorrectInput = isCorrectInput(state = currentState)
            )
        }
    }

    private fun onSecondNameChange(secondName: String) {
        _uiState.update { currentState ->
            currentState.copy(
                secondName = secondName,
                secondNameError = false,
                isCorrectInput = isCorrectInput(state = currentState)
            )
        }
    }

    private fun onMobilePhoneChange(mobilePhone: String) {
        _uiState.update { currentState ->
            currentState.copy(
                mobilePhone = mobilePhone,
                mobilePhoneError = false,
                isCorrectInput = isCorrectInput(state = currentState)
            )
        }
    }

    private fun isCorrectInput(state: AuthContract.State): Boolean {
        return !state.firstNameError && !state.secondNameError && !state.mobilePhoneError
    }
}