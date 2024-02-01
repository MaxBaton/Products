package com.maxbay.productsTestEffectiveMobile.data.repository

import com.maxbay.productsTestEffectiveMobile.data.mappers.toStorage
import com.maxbay.productsTestEffectiveMobile.data.storage.api.UserStorage
import com.maxbay.productsTestEffectiveMobile.models.UserSignUp
import com.maxbay.productsTestEffectiveMobile.repository.AuthRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AuthRepositoryImpl(
    private val userStorage: UserStorage,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
): AuthRepository {
    override suspend fun signUp(userSignUp: UserSignUp) {
        withContext(context = dispatcher) {
            userStorage.save(userModelStorage = userSignUp.toStorage())
        }
    }
}