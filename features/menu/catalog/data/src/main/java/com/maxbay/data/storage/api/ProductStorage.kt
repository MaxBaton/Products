package com.maxbay.data.storage.api

import com.maxbay.data.storage.models.ProductIsFavoriteModelStorage
import kotlinx.coroutines.flow.Flow

interface ProductStorage {
    suspend fun getAllIsFavorites(): List<ProductIsFavoriteModelStorage>
    fun observeIsFavorites(): Flow<List<ProductIsFavoriteModelStorage>>
    suspend fun addIsFavorite(productIsFavoriteModelStorage: ProductIsFavoriteModelStorage)
}