package com.maxbay.presentation.di

import com.maxbay.domain.repository.ProductRepository

interface CatalogFeatureDeps {
    val productRepository: ProductRepository
}