package com.maxbay.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.maxbay.api.AuthApi
import com.maxbay.productsTestEffectiveMobile.useCase.GetRegisterUserUseCase

@Suppress("UNCHECKED_CAST")
class ProfileViewModelFactory(
    private val getRegisterUserUseCase: GetRegisterUserUseCase
): ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ProfileViewModel(getRegisterUserUseCase = getRegisterUserUseCase) as T
    }
}