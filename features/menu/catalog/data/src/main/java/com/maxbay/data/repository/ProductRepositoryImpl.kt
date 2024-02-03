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
    private var allProducts = emptyList<Product>()

    override suspend fun getProducts(): Flow<List<Product>> {
        val productsNetwork = productApi.getAllProducts().items
        allProducts = productsNetwork.toDomain()
        productsFlow.update {
            productsNetwork.toDomain()
        }
        return productsFlow
    }

    override suspend fun filterProductsByTag(tag: String) {
        val filterProducts = if (allProducts.isNotEmpty()) {
            allProducts.filter {
                it.tags.contains(tag)
            }
        }else {
            productApi.getAllProducts().items.filter {
                it.tags.contains(tag)
            }.toDomain()
        }

        productsFlow.update {
            filterProducts
        }
    }

    override suspend fun filterAllProducts() {
        val products = if (allProducts.isNotEmpty()) {
            allProducts
        }else {
            productApi.getAllProducts().items.toDomain()
        }

        productsFlow.update {
            products
        }
    }

    override suspend fun changeFavoriteStatus(productId: String, isFavorite: Boolean) {
        productsFlow.update { currentProducts ->
            currentProducts.map { product ->
                if (product.id == productId) {
                    product.copy(isFavorite = isFavorite)
                }else {
                    product
                }
            }
        }
    }
}