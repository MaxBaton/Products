package com.maxbay.presentation.di

import com.maxbay.api.AuthApi
import com.maxbay.api.CatalogApi
import com.maxbay.presentation.viewModel.ProfileViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ProfileModule {
    @Provides
    fun provideProfileViewModelFactory(
        authApi: AuthApi,
        catalogApi: CatalogApi
    ): ProfileViewModelFactory {
        return ProfileViewModelFactory(
            getRegisterUserUseCase = authApi.getResisterUserUseCase(),
            signOutUseCase = authApi.signOutUseCase(),
            observeFavoritesCountUseCase = catalogApi.observeFavoritesCountUseCase()
        )
    }
}