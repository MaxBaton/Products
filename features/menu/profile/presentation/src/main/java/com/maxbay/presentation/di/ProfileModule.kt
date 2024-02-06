package com.maxbay.presentation.di

import com.maxbay.api.AuthApi
import com.maxbay.presentation.viewModel.ProfileViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ProfileModule {
    @Provides
    fun provideProfileViewModelFactory(authApi: AuthApi): ProfileViewModelFactory {
        return ProfileViewModelFactory(getRegisterUserUseCase = authApi.getResisterUserUseCase())
    }
}