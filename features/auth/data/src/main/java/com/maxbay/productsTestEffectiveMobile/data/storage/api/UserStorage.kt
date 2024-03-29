package com.maxbay.productsTestEffectiveMobile.data.storage.api

import com.maxbay.productsTestEffectiveMobile.data.storage.models.UserModelStorage

interface UserStorage {
    suspend fun save(userModelStorage: UserModelStorage)
    suspend fun getRegisterUserId(): Int
    suspend fun getRegisterUser(): UserModelStorage
    suspend fun deleteUserById(userId: Int)
}