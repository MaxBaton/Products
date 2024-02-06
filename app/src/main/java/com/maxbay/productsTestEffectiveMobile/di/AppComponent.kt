package com.maxbay.productsTestEffectiveMobile.di

import android.content.Context
import com.maxbay.api.AuthApi
import com.maxbay.domain.repository.ProductRepository
import com.maxbay.presentation.di.CatalogFeatureDeps
import com.maxbay.presentation.di.ProfileFeatureDeps
import com.maxbay.productsTestEffectiveMobile.di.modules.DatabaseModule
import com.maxbay.productsTestEffectiveMobile.di.modules.FeaturesModule
import com.maxbay.productsTestEffectiveMobile.di.modules.NetworkModule
import com.maxbay.productsTestEffectiveMobile.di.modules.RepositoriesModule
import com.maxbay.productsTestEffectiveMobile.di.modules.ViewModelModule
import com.maxbay.productsTestEffectiveMobile.repository.AuthRepository
import com.maxbay.productsTestEffectiveMobile.viewModel.AppViewModelFactory
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        DatabaseModule::class,
        RepositoriesModule::class,
        ViewModelModule::class,
        NetworkModule::class,
        FeaturesModule::class
    ]
)
interface AppComponent: AuthFeatureDeps, CatalogFeatureDeps, ProfileFeatureDeps {
    override val authRepository: AuthRepository
    override val productRepository: ProductRepository
    override val authApi: AuthApi

    val appViewModelFactory: AppViewModelFactory

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun addContext(context: Context): Builder
        fun build(): AppComponent
    }
}