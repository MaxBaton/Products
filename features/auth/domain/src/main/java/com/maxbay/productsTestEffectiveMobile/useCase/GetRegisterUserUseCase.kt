package com.maxbay.productsTestEffectiveMobile.useCase

import com.maxbay.productsTestEffectiveMobile.models.User
import com.maxbay.productsTestEffectiveMobile.repository.AuthRepository

class GetRegisterUserUseCase(
    private val authRepository: AuthRepository
) {
    suspend fun execute(): User = authRepository.getRegisterUser()
}