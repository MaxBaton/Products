package com.maxbay.productsTestEffectiveMobile.di

import com.maxbay.productsTestEffectiveMobile.useCase.GetRegisterUserUseCase
import com.maxbay.productsTestEffectiveMobile.useCase.SignOutUseCase
import com.maxbay.productsTestEffectiveMobile.viewModel.AuthViewModelFactory
import dagger.Component

@AuthScope
@Component(
    modules = [AuthModule::class],
    dependencies = [AuthFeatureDeps::class]
)
interface AuthComponent {
    val authViewModelFactory: AuthViewModelFactory
    val getRegisterUserUseCase: GetRegisterUserUseCase
    val signOutUseCase: SignOutUseCase

    @Component.Builder
    interface Builder {
        fun addDeps(deps: AuthFeatureDeps): Builder
        fun build(): AuthComponent
    }
}