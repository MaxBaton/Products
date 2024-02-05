package com.maxbay.domain.usecase

import com.maxbay.domain.repository.ProductRepository

class ChangeFavoriteStatusUseCase(
    private val productRepository: ProductRepository
) {
    suspend fun execute(productId: String, isFavorite: Boolean) = productRepository.changeFavoriteStatus(
        productId = productId,
        isFavorite = isFavorite
    )
}