package com.maxbay.data.repository

import com.maxbay.data.mappers.toDomain
import com.maxbay.data.network.api.ProductApi
import com.maxbay.domain.models.Product
import com.maxbay.domain.repository.ProductRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

class ProductRepositoryImpl(
    private val productApi: ProductApi
): ProductRepository {
    private val productsFlow = MutableStateFlow<List<Product>>(emptyList())

    override suspend fun getProducts(): Flow<List<Product>> {
        val productsNetwork = productApi.getAllProducts().items
        productsFlow.update {
            productsNetwork.toDomain()
        }
        return productsFlow
    }
}