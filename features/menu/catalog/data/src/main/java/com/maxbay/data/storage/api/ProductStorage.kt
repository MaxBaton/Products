package com.maxbay.data.storage.api

import com.maxbay.data.storage.models.ProductIsFavoriteModelStorage

interface ProductStorage {
    suspend fun getAllIsFavorites(): List<ProductIsFavoriteModelStorage>
    suspend fun addIsFavorite(productIsFavoriteModelStorage: ProductIsFavoriteModelStorage)
}