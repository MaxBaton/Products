package com.maxbay.domain.repository

import com.maxbay.domain.models.Product
import kotlinx.coroutines.flow.Flow

interface ProductRepository {
    suspend fun getProducts(): Flow<List<Product>>
    suspend fun filterProductsByTag(tag: String)
    suspend fun filterAllProducts()
}