package com.maxbay.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.maxbay.api.AuthApi
import com.maxbay.productsTestEffectiveMobile.useCase.GetRegisterUserUseCase
import com.maxbay.productsTestEffectiveMobile.useCase.SignOutUseCase

@Suppress("UNCHECKED_CAST")
class ProfileViewModelFactory(
    private val getRegisterUserUseCase: GetRegisterUserUseCase,
    private val signOutUseCase: SignOutUseCase
): ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ProfileViewModel(
            getRegisterUserUseCase = getRegisterUserUseCase,
            signOutUseCase = signOutUseCase
        ) as T
    }
}