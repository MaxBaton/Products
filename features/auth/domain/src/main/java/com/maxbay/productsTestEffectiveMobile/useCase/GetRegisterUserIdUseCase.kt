package com.maxbay.productsTestEffectiveMobile.useCase

import com.maxbay.productsTestEffectiveMobile.repository.AuthRepository

class GetRegisterUserIdUseCase(private val authRepository: AuthRepository) {
    suspend fun execute(): Int = authRepository.getRegisterUserId()
}