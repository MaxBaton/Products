package com.maxbay.productsTestEffectiveMobile.di

import com.maxbay.productsTestEffectiveMobile.repository.AuthRepository
import com.maxbay.productsTestEffectiveMobile.useCase.SignUpUserUseCase
import com.maxbay.productsTestEffectiveMobile.viewModel.AuthViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class AuthModule {
    @Provides
    fun provideSignUpUseCase(authRepository: AuthRepository): SignUpUserUseCase {
        return SignUpUserUseCase(authRepository = authRepository)
    }

    @Provides
    fun provideAuthViewModelFactory(signUpUserUseCase: SignUpUserUseCase): AuthViewModelFactory {
        return AuthViewModelFactory(signUpUserUseCase = signUpUserUseCase)
    }
}