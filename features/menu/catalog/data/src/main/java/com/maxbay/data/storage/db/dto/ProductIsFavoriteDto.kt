package com.maxbay.data.storage.db.dto

import androidx.room.ColumnInfo

data class ProductIsFavoriteDto(
    @ColumnInfo(name = ID)
    val id: String,
    @ColumnInfo(name = IS_FAVORITE)
    val isFavorite: Boolean
) {
    companion object {
        const val ID = "id_product_dto"
        const val IS_FAVORITE = "is_favorite_product_dto"
    }
}
