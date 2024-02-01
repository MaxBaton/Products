package com.maxbay.productsTestEffectiveMobile.di.modules

import com.maxbay.productsTestEffectiveMobile.repository.AuthRepository
import com.maxbay.productsTestEffectiveMobile.useCase.GetRegisterUserIdUseCase
import com.maxbay.productsTestEffectiveMobile.viewModel.AppViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ViewModelModule {
    @Provides
    fun provideAppViewModelFactory(getRegisterUserIdUseCase: GetRegisterUserIdUseCase): AppViewModelFactory {
        return AppViewModelFactory(getRegisterUserIdUseCase = getRegisterUserIdUseCase)
    }

    @Provides
    fun provideGetRegisterUserIdUseCase(authRepository: AuthRepository): GetRegisterUserIdUseCase {
        return GetRegisterUserIdUseCase(authRepository = authRepository)
    }
}