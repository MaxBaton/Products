package com.maxbay.productsTestEffectiveMobile.di

import android.content.Context
import com.maxbay.productsTestEffectiveMobile.di.modules.DatabaseModule
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
        ViewModelModule::class
    ]
)
interface AppComponent: AuthFeatureDeps {
    override val authRepository: AuthRepository
    val appViewModelFactory: AppViewModelFactory

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun addContext(context: Context): Builder
        fun build(): AppComponent
    }
}