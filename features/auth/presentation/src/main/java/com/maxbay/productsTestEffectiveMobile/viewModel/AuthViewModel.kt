package com.maxbay.productsTestEffectiveMobile.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maxbay.productsTestEffectiveMobile.models.UserSignUp
import com.maxbay.productsTestEffectiveMobile.useCase.SignUpUserUseCase
import com.maxbay.productsTestEffectiveMobile.utils.isCorrectFirstName
import com.maxbay.productsTestEffectiveMobile.utils.isCorrectMobilePhone
import com.maxbay.productsTestEffectiveMobile.utils.isCorrectSecondName
import com.maxbay.productsTestEffectiveMobile.utils.isCorrectMobilePhoneLength
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class AuthViewModel(
    private val signUpUserUseCase: SignUpUserUseCase
): ViewModel(), AuthContract {
    private val _uiState = MutableStateFlow<AuthContract.State>(AuthContract.State.initial())
    override val uiState: StateFlow<AuthContract.State> = _uiState.asStateFlow()

    private val _effect = MutableStateFlow<AuthContract.Effect>(AuthContract.Effect.None)
    override val effect: StateFlow<AuthContract.Effect> = _effect.asStateFlow()

    override fun handleEvent(event: AuthContract.Event) {
        when(event) {
            is AuthContract.Event.FistNameChange -> onFirstNameChange(firstName = event.firstName)
            is AuthContract.Event.SecondNameChange -> onSecondNameChange(secondName = event.secondName)
            is AuthContract.Event.MobilePhoneChange -> onMobilePhoneChange(mobilePhone = event.mobilePhone)
            AuthContract.Event.SignUp -> signUp()
        }
    }

    override fun consume() {
        _effect.update {
            AuthContract.Effect.None
        }
    }

    private fun onFirstNameChange(firstName: String) {
        _uiState.update { currentState ->
            val isCorrectFirstName = firstName.isCorrectFirstName()
            currentState.copy(
                firstName = firstName,
                firstNameError = !isCorrectFirstName,
                isCorrectInput = isCorrectFirstName
                        && currentState.secondName.isCorrectSecondName()
                        && currentState.mobilePhone.isCorrectMobilePhone()
            )
        }
    }

    private fun onSecondNameChange(secondName: String) {
        _uiState.update { currentState ->
            val isCorrectSecondName = secondName.isCorrectSecondName()
            currentState.copy(
                secondName = secondName,
                secondNameError = !isCorrectSecondName,
                isCorrectInput = isCorrectSecondName
                        && currentState.firstName.isCorrectFirstName()
                        && currentState.mobilePhone.isCorrectMobilePhone()
            )
        }
    }

    private fun onMobilePhoneChange(mobilePhone: String) {
        if (mobilePhone.isCorrectMobilePhoneLength()) {
            _uiState.update { currentState ->
                val isCorrectMobilePhone = mobilePhone.isCorrectMobilePhone()
                currentState.copy(
                    mobilePhone = mobilePhone,
                    mobilePhoneError = !isCorrectMobilePhone,
                    isCorrectInput = isCorrectMobilePhone
                            && currentState.firstName.isCorrectFirstName()
                            && currentState.secondName.isCorrectSecondName()
                )
            }
        }
    }

    private fun signUp() {
        val exceptionHandler = CoroutineExceptionHandler { _, _ ->
            _effect.update {
                AuthContract.Effect.None
            }
        }

        viewModelScope.launch(exceptionHandler) {
            val firstNameCorrect = _uiState.value.firstName.isCorrectFirstName()
            val secondNameCorrect = _uiState.value.secondName.isCorrectSecondName()
            val mobilePhoneCorrect = _uiState.value.mobilePhone.isCorrectMobilePhone()
            if (firstNameCorrect && secondNameCorrect && mobilePhoneCorrect) {
                signUpUserUseCase.execute(
                    userSignUp = UserSignUp(
                        firstName = _uiState.value.firstName,
                        secondName = _uiState.value.secondName,
                        mobilePhone = _uiState.value.mobilePhone
                    )
                )

                _effect.update {
                    AuthContract.Effect.SignUp
                }
            }else {
                _uiState.update { currentState ->
                    currentState.copy(
                        firstNameError = !firstNameCorrect,
                        secondNameError = !secondNameCorrect,
                        mobilePhoneError = !mobilePhoneCorrect,
                        isCorrectInput = false
                    )
                }
            }
        }
    }
}