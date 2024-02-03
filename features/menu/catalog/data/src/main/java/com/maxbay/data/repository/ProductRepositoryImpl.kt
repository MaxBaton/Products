package com.maxbay.data.repository

import com.maxbay.data.mappers.toDomain
import com.maxbay.data.network.api.ProductApi
import com.maxbay.data.storage.api.ProductStorage
import com.maxbay.data.storage.models.ProductIsFavoriteModelStorage
import com.maxbay.domain.models.Product
import com.maxbay.domain.repository.ProductRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

class ProductRepositoryImpl(
    private val productApi: ProductApi,
    private val productStorage: ProductStorage
): ProductRepository {
    private val productsFlow = MutableStateFlow<List<Product>>(emptyList())
    private var allProducts = emptyList<Product>()

    override suspend fun getProducts(): Flow<List<Product>> {
        val productsNetwork = productApi.getAllProducts().items
        val productsIsFavorite = productStorage.getAllIsFavorites()
        val products = productsNetwork.toDomain(productsIsFavorite = productsIsFavorite)
        allProducts = products
        productsFlow.update {
            products
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
            }.toDomain(productsIsFavorite = productStorage.getAllIsFavorites())
        }

        productsFlow.update {
            filterProducts
        }
    }

    override suspend fun filterAllProducts() {
        val products = if (allProducts.isNotEmpty()) {
            allProducts
        }else {
            productApi.getAllProducts().items.toDomain(
                productsIsFavorite = productStorage.getAllIsFavorites()
            )
        }

        productsFlow.update {
            products
        }
    }

    override suspend fun changeFavoriteStatus(productId: String, isFavorite: Boolean) {
        productStorage.addIsFavorite(
            productIsFavoriteModelStorage = ProductIsFavoriteModelStorage(id = productId, isFavorite = isFavorite)
        )

        productsFlow.update { currentProducts ->
            val newProducts = currentProducts.map { product ->
                if (product.id == productId) {
                    product.copy(isFavorite = isFavorite)
                }else {
                    product
                }
            }

            allProducts = allProducts.map { product ->
                if (product.id == productId) {
                    product.copy(isFavorite = isFavorite)
                }else {
                    product
                }
            }

            newProducts
        }
    }
}