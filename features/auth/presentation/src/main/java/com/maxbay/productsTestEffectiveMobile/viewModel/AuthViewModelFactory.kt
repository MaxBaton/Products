package com.maxbay.productsTestEffectiveMobile.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.maxbay.productsTestEffectiveMobile.useCase.SignUpUserUseCase

@Suppress("UNCHECKED_CAST")
class AuthViewModelFactory(
    private val signUpUserUseCase: SignUpUserUseCase
): ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return AuthViewModel(signUpUserUseCase = signUpUserUseCase) as T
    }
}