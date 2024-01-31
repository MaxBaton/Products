package com.maxbay.productsTestEffectiveMobile.useCase

import com.maxbay.productsTestEffectiveMobile.models.UserSignUp
import com.maxbay.productsTestEffectiveMobile.repository.AuthRepository

class SignUpUserUseCase(private val authRepository: AuthRepository) {
    suspend fun execute(userSignUp: UserSignUp) = authRepository.signUp(userSignUp = userSignUp)
}