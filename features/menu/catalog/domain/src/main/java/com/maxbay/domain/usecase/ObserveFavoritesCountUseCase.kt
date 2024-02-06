package com.maxbay.domain.usecase

import com.maxbay.domain.repository.ProductRepository
import kotlinx.coroutines.flow.Flow

class ObserveFavoritesCountUseCase(
    private val productRepository: ProductRepository
) {
    suspend fun execute(): Flow<Int> = productRepository.observeFavoritesCount()
}