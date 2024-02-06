package com.maxbay.data.storage.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.maxbay.data.storage.db.dto.ProductIsFavoriteDto
import com.maxbay.data.storage.db.entities.ProductIsFavoriteEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductDao {
    @Query(
        "select "
        + ProductIsFavoriteEntity.ID + " as " + ProductIsFavoriteDto.ID + ", "
        + ProductIsFavoriteEntity.IS_FAVORITE + " as " + ProductIsFavoriteDto.IS_FAVORITE
        + " from " + ProductIsFavoriteEntity.TABLE_NAME
    )
    suspend fun getAllIsFavorites(): List<ProductIsFavoriteDto>

    @Query(
        "select "
                + ProductIsFavoriteEntity.ID + " as " + ProductIsFavoriteDto.ID + ", "
                + ProductIsFavoriteEntity.IS_FAVORITE + " as " + ProductIsFavoriteDto.IS_FAVORITE
                + " from " + ProductIsFavoriteEntity.TABLE_NAME
                + " where " + ProductIsFavoriteEntity.IS_FAVORITE + " = 1"
    )
    fun getIsFavorites(): Flow<List<ProductIsFavoriteDto>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addIsFavorite(productIsFavoriteEntity: ProductIsFavoriteEntity)
}