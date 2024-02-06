package com.maxbay.api

import com.maxbay.productsTestEffectiveMobile.useCase.GetRegisterUserUseCase
import com.maxbay.productsTestEffectiveMobile.useCase.SignOutUseCase

interface AuthApi {
    fun getResisterUserUseCase(): GetRegisterUserUseCase
    fun signOutUseCase(): SignOutUseCase
}