package com.maxbay.productsTestEffectiveMobile.repository

import com.maxbay.productsTestEffectiveMobile.models.User
import com.maxbay.productsTestEffectiveMobile.models.UserSignUp

interface AuthRepository {
    suspend fun signUp(userSignUp: UserSignUp)
    suspend fun getRegisterUserId(): Int
    suspend fun getRegisterUser(): User
}