package com.maxbay.productsTestEffectiveMobile.di

import com.maxbay.productsTestEffectiveMobile.viewModel.AuthViewModelFactory
import dagger.Component

@AuthScope
@Component(
    modules = [AuthModule::class],
    dependencies = [AuthFeatureDeps::class]
)
interface AuthComponent {
    val authViewModelFactory: AuthViewModelFactory

    @Component.Builder
    interface Builder {
        fun addDeps(deps: AuthFeatureDeps): Builder
        fun build(): AuthComponent
    }
}