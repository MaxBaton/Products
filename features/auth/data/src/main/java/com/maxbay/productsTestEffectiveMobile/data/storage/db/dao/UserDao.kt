package com.maxbay.productsTestEffectiveMobile.data.storage.db.dao

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.maxbay.productsTestEffectiveMobile.data.storage.db.entities.UserEntity

interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun add(userEntity: UserEntity)
}