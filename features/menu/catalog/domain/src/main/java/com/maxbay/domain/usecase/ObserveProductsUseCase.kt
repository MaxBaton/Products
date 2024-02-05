package com.maxbay.domain.usecase

import com.maxbay.domain.models.Product
import com.maxbay.domain.repository.ProductRepository
import kotlinx.coroutines.flow.Flow

class ObserveProductsUseCase(private val productRepository: ProductRepository) {
    suspend fun execute(): Flow<List<Product>> = productRepository.getProducts()
}