package com.maxbay.productsTestEffectiveMobile.di

import android.content.Context
import com.maxbay.domain.repository.ProductRepository
import com.maxbay.presentation.di.CatalogFeatureDeps
import com.maxbay.productsTestEffectiveMobile.di.modules.DatabaseModule
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
        NetworkModule::class
    ]
)
interface AppComponent: AuthFeatureDeps, CatalogFeatureDeps {
    override val authRepository: AuthRepository
    override val productRepository: ProductRepository

    val appViewModelFactory: AppViewModelFactory

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun addContext(context: Context): Builder
        fun build(): AppComponent
    }
}