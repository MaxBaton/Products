package com.maxbay.domain.repository

import com.maxbay.domain.models.Product
import com.maxbay.domain.models.SortOrder
import kotlinx.coroutines.flow.Flow

interface ProductRepository {
    suspend fun getProducts(): Flow<List<Product>>
    suspend fun filterProductsByTag(tag: String)
    suspend fun filterAllProducts()
    suspend fun changeFavoriteStatus(productId: String, isFavorite: Boolean)
    suspend fun sortProducts(sortOrder: SortOrder)
    suspend fun observeFavoritesCount(): Flow<Int>
}