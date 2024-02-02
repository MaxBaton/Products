package com.maxbay.productsTestEffectiveMobile.di.modules

import com.maxbay.data.network.api.ProductApi
import com.maxbay.data.repository.ProductRepositoryImpl
import com.maxbay.domain.repository.ProductRepository
import com.maxbay.productsTestEffectiveMobile.data.repository.AuthRepositoryImpl
import com.maxbay.productsTestEffectiveMobile.data.storage.api.UserStorage
import com.maxbay.productsTestEffectiveMobile.data.storage.db.api.UserDbStorage
import com.maxbay.productsTestEffectiveMobile.data.storage.db.dao.UserDao
import com.maxbay.productsTestEffectiveMobile.repository.AuthRepository
import dagger.Module
import dagger.Provides
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
class RepositoriesModule {
    @Provides
    @Singleton
    fun provideAuthRepository(@UserDbStorageClass userStorage: UserStorage): AuthRepository {
        return AuthRepositoryImpl(userStorage = userStorage)
    }

    @Provides
    @Singleton
    @UserDbStorageClass
    fun provideUserDbStorage(userDao: UserDao): UserStorage {
        return UserDbStorage(userDao = userDao)
    }

    @Provides
    @Singleton
    fun provideProductRepository(productApi: ProductApi): ProductRepository {
        return ProductRepositoryImpl(productApi = productApi)
    }
}

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class UserDbStorageClass