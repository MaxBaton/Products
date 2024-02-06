package com.maxbay.presentation.api

import com.maxbay.api.CatalogApi
import com.maxbay.domain.usecase.ObserveFavoritesCountUseCase
import com.maxbay.presentation.di.CatalogFeatureDeps
import com.maxbay.presentation.di.CatalogFeatureDepsProvider
import com.maxbay.presentation.di.DaggerCatalogComponent

class CatalogApiImpl: CatalogApi {
    private val catalogComponent by lazy {
        DaggerCatalogComponent
            .builder()
            .addDeps(deps = CatalogFeatureDepsProvider.deps)
            .build()
    }

    override fun observeFavoritesCountUseCase(): ObserveFavoritesCountUseCase {
        return catalogComponent.observeFavoritesCountUseCase
    }
}