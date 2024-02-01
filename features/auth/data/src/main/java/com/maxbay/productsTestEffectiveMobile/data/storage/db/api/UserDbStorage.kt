package com.maxbay.productsTestEffectiveMobile.data.storage.db.api

import com.maxbay.productsTestEffectiveMobile.data.mappers.toEntity
import com.maxbay.productsTestEffectiveMobile.data.storage.api.UserStorage
import com.maxbay.productsTestEffectiveMobile.data.storage.db.dao.UserDao
import com.maxbay.productsTestEffectiveMobile.data.storage.models.UserModelStorage

class UserDbStorage(private val userDao: UserDao): UserStorage {
    override suspend fun save(userModelStorage: UserModelStorage) {
        userDao.add(userEntity = userModelStorage.toEntity())
    }
}