package com.maxbay.presentation.di

import com.maxbay.domain.usecase.ObserveFavoritesCountUseCase
import com.maxbay.presentation.viewModel.CatalogViewModelFactory
import dagger.Component

@CatalogScope
@Component(
    modules = [CatalogModule::class],
    dependencies = [CatalogFeatureDeps::class]
)
interface CatalogComponent {
    val catalogViewModelFactory: CatalogViewModelFactory
    val observeFavoritesCountUseCase: ObserveFavoritesCountUseCase

    @Component.Builder
    interface Builder {
        fun addDeps(deps: CatalogFeatureDeps): Builder
        fun build(): CatalogComponent
    }
}