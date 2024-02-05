package com.maxbay.domain.usecase

import com.maxbay.domain.repository.ProductRepository

class FilterAllProductsUseCase(
    private val productRepository: ProductRepository
) {
    suspend fun execute() = productRepository.filterAllProducts()
}