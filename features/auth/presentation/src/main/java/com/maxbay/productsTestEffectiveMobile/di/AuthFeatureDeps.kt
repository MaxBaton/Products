package com.maxbay.productsTestEffectiveMobile.di

import com.maxbay.productsTestEffectiveMobile.repository.AuthRepository

interface AuthFeatureDeps {
    val authRepository: AuthRepository
}