package com.maxbay.productsTestEffectiveMobile.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.maxbay.productsTestEffectiveMobile.useCase.GetRegisterUserIdUseCase

@Suppress("UNCHECKED_CAST")
class AppViewModelFactory(
    private val getRegisterUserIdUseCase: GetRegisterUserIdUseCase
): ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return AppViewModel(getRegisterUserIdUseCase = getRegisterUserIdUseCase) as T
    }
}