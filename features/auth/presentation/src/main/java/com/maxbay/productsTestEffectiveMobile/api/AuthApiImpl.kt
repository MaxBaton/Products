package com.maxbay.productsTestEffectiveMobile.api

import com.maxbay.api.AuthApi
import com.maxbay.productsTestEffectiveMobile.di.AuthFeatureDepsProvider
import com.maxbay.productsTestEffectiveMobile.di.DaggerAuthComponent
import com.maxbay.productsTestEffectiveMobile.useCase.GetRegisterUserUseCase
import com.maxbay.productsTestEffectiveMobile.useCase.SignOutUseCase

class AuthApiImpl: AuthApi {
    private val authComponent by lazy {
        DaggerAuthComponent
            .builder()
            .addDeps(deps = AuthFeatureDepsProvider.deps)
            .build()
    }

    override fun getResisterUserUseCase(): GetRegisterUserUseCase {
        return authComponent.getRegisterUserUseCase
    }

    override fun signOutUseCase(): SignOutUseCase {
        return authComponent.signOutUseCase
    }
}