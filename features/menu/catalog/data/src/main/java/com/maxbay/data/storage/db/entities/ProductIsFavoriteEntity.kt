package com.maxbay.data.storage.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = ProductIsFavoriteEntity.TABLE_NAME)
data class ProductIsFavoriteEntity(
    @PrimaryKey
    @ColumnInfo(name = ID)
    val id: String,
    @ColumnInfo(name = IS_FAVORITE)
    val isFavorite: Boolean
) {
    companion object {
        const val TABLE_NAME = "ProductIsFavorite"
        const val ID = "id"
        const val IS_FAVORITE = "is_favorite"
    }
}
