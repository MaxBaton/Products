package com.maxbay.productsTestEffectiveMobile.useCase

import com.maxbay.productsTestEffectiveMobile.repository.AuthRepository

class SignOutUseCase(
    private val authRepository: AuthRepository
) {
    suspend fun execute(userId: Int) = authRepository.signOut(userId = userId)
}