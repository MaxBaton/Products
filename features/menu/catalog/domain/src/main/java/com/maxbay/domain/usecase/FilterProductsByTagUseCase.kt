package com.maxbay.domain.usecase

import com.maxbay.domain.repository.ProductRepository

class FilterProductsByTagUseCase(
    private val productRepository: ProductRepository
) {
    suspend fun execute(tag: String) = productRepository.filterProductsByTag(tag = tag)
}