package com.maxbay.presentation.di

import com.maxbay.domain.repository.ProductRepository
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
    fun provideCatalogViewModelFactory(observeProductsUseCase: ObserveProductsUseCase): CatalogViewModelFactory {
        return CatalogViewModelFactory(observeProductsUseCase = observeProductsUseCase)
    }
}