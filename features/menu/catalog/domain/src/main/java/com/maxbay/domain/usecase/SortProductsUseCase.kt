package com.maxbay.domain.usecase

import com.maxbay.domain.models.SortOrder
import com.maxbay.domain.repository.ProductRepository

class SortProductsUseCase(
    private val productRepository: ProductRepository
) {
    suspend fun execute(sortCode: Int) {
        val sortOrder =  SortOrder.entries.find { it.ordinal == sortCode }
        sortOrder?.let { order ->
            productRepository.sortProducts(sortOrder = order)
        }
    }
}