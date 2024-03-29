package com.maxbay.data.storage.db.api

import com.maxbay.data.mappers.toEntity
import com.maxbay.data.mappers.toStorage
import com.maxbay.data.storage.api.ProductStorage
import com.maxbay.data.storage.db.dao.ProductDao
import com.maxbay.data.storage.models.ProductIsFavoriteModelStorage
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ProductDbStorage(
    private val productDao: ProductDao
): ProductStorage {
    override suspend fun getAllIsFavorites(): List<ProductIsFavoriteModelStorage> {
        return productDao.getAllIsFavorites().toStorage()
    }

    override fun observeIsFavorites(): Flow<List<ProductIsFavoriteModelStorage>> {
        return productDao.getIsFavorites().map {
            it.toStorage()
        }
    }

    override suspend fun addIsFavorite(productIsFavoriteModelStorage: ProductIsFavoriteModelStorage) {
        productDao.addIsFavorite(productIsFavoriteEntity = productIsFavoriteModelStorage.toEntity())
    }
}