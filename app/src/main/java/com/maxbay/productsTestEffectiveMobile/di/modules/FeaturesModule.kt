package com.maxbay.productsTestEffectiveMobile.di.modules

import com.maxbay.api.AuthApi
import com.maxbay.api.CatalogApi
import com.maxbay.presentation.api.CatalogApiImpl
import com.maxbay.productsTestEffectiveMobile.api.AuthApiImpl
import dagger.Module
import dagger.Provides

@Module
class FeaturesModule {
    @Provides
    fun provideAuthApi(): AuthApi {
        return AuthApiImpl()
    }

    @Provides
    fun provideCatalogApi(): CatalogApi {
        return CatalogApiImpl()
    }
}