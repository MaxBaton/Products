package com.maxbay.data.storage.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.maxbay.data.storage.db.dto.ProductIsFavoriteDto
import com.maxbay.data.storage.db.entities.ProductIsFavoriteEntity

@Dao
interface ProductDao {
    @Query(
        "select "
        + ProductIsFavoriteEntity.ID + " as " + ProductIsFavoriteDto.ID + ", "
        + ProductIsFavoriteEntity.IS_FAVORITE + " as " + ProductIsFavoriteDto.IS_FAVORITE
        + " from " + ProductIsFavoriteEntity.TABLE_NAME
    )
    suspend fun getAllIsFavorites(): List<ProductIsFavoriteDto>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addIsFavorite(productIsFavoriteEntity: ProductIsFavoriteEntity)
}