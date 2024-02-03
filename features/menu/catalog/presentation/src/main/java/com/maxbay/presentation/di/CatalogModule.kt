package com.maxbay.presentation.di

import com.maxbay.domain.repository.ProductRepository
import com.maxbay.domain.usecase.FilterAllProductsUseCase
import com.maxbay.domain.usecase.FilterProductsByTagUseCase
import com.maxbay.domain.usecase.ObserveProductsUseCase
import com.maxbay.presentation.viewModel.CatalogViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class CatalogModule {
    @Provides
    fun provideObserveProductsUseCase(productRepository: ProductRepository): ObserveProductsUseCase {
        return ObserveProductsUseCase(productRepository = productRepository)
    }

    @Provides
    fun provideFilterProductsByTagUseCase(productRepository: ProductRepository): FilterProductsByTagUseCase {
        return FilterProductsByTagUseCase(productRepository = productRepository)
    }

    @Provides
    fun provideFilterAllProductsUseCase(productRepository: ProductRepository): FilterAllProductsUseCase {
        return FilterAllProductsUseCase(productRepository = productRepository)
    }

    @Provides
    fun provideCatalogViewModelFactory(
        observeProductsUseCase: ObserveProductsUseCase,
        filterProductsByTagUseCase: FilterProductsByTagUseCase,
        filterAllProductsUseCase: FilterAllProductsUseCase
    ): CatalogViewModelFactory {
        return CatalogViewModelFactory(
            observeProductsUseCase = observeProductsUseCase,
            filterProductsByTagUseCase = filterProductsByTagUseCase,
            filterAllProductsUseCase = filterAllProductsUseCase
        )
    }
}