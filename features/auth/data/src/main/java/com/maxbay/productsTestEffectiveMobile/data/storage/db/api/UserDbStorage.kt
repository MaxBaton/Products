package com.maxbay.productsTestEffectiveMobile.data.storage.db.api

import com.maxbay.productsTestEffectiveMobile.data.mappers.toEntity
import com.maxbay.productsTestEffectiveMobile.data.mappers.toStorage
import com.maxbay.productsTestEffectiveMobile.data.storage.api.UserStorage
import com.maxbay.productsTestEffectiveMobile.data.storage.db.dao.UserDao
import com.maxbay.productsTestEffectiveMobile.data.storage.models.UserModelStorage

class UserDbStorage(private val userDao: UserDao): UserStorage {
    override suspend fun save(userModelStorage: UserModelStorage) {
        userDao.add(userEntity = userModelStorage.toEntity())
    }

    override suspend fun getRegisterUserId(): Int {
        return userDao.getUserId()
    }

    override suspend fun getRegisterUser(): UserModelStorage {
        return userDao.getRegisterUser().toStorage()
    }

    override suspend fun deleteUserById(userId: Int) {
        userDao.deleteUserById(userId = userId)
    }
}