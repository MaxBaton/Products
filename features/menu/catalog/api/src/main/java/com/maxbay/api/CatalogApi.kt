package com.maxbay.api

import com.maxbay.domain.usecase.ObserveFavoritesCountUseCase

interface CatalogApi {
    fun observeFavoritesCountUseCase(): ObserveFavoritesCountUseCase
}