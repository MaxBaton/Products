package com.maxbay.productsTestEffectiveMobile.di.modules

import com.maxbay.api.AuthApi
import com.maxbay.productsTestEffectiveMobile.api.AuthApiImpl
import dagger.Module
import dagger.Provides

@Module
class FeaturesModule {
    @Provides
    fun provideAuthApi(): AuthApi {
        return AuthApiImpl()
    }
}