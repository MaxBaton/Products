package com.maxbay.productsTestEffectiveMobile.di.modules

import com.maxbay.data.network.api.ProductApi
import com.maxbay.productsTestEffectiveMobile.network.AppRetrofit
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class NetworkModule {
    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return AppRetrofit.create()
    }

    @Provides
    @Singleton
    fun provideProductApi(retrofit: Retrofit): ProductApi {
        return retrofit.create(ProductApi::class.java)
    }
}