package com.maxbay.productsTestEffectiveMobile.data.storage.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.maxbay.productsTestEffectiveMobile.data.storage.db.entities.UserEntity

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun add(userEntity: UserEntity)

    @Query(
        "select " + UserEntity.ID
        + " from " + UserEntity.TABLE_NAME
    )
    suspend fun getUserId(): Int
}