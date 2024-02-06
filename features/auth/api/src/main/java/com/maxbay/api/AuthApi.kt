package com.maxbay.api

import com.maxbay.productsTestEffectiveMobile.useCase.GetRegisterUserUseCase

interface AuthApi {
    fun getResisterUserUseCase(): GetRegisterUserUseCase
}