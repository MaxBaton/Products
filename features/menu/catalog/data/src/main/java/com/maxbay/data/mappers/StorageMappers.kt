package com.maxbay.data.mappers

import com.maxbay.data.storage.db.dto.ProductIsFavoriteDto
import com.maxbay.data.storage.db.entities.ProductIsFavoriteEntity
import com.maxbay.data.storage.models.ProductIsFavoriteModelStorage

internal fun ProductIsFavoriteModelStorage.toEntity() = ProductIsFavoriteEntity(
    id = this.id,
    isFavorite = this.isFavorite
)

internal fun List<ProductIsFavoriteModelStorage>.toEntity() = this.map { it.toEntity() }

private fun ProductIsFavoriteDto.toStorage() = ProductIsFavoriteModelStorage(
    id = this.id,
    isFavorite = this.isFavorite
)

internal fun List<ProductIsFavoriteDto>.toStorage() = this.map { it.toStorage() }