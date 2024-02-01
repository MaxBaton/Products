package com.maxbay.productsTestEffectiveMobile.di.modules

import com.maxbay.productsTestEffectiveMobile.data.repository.AuthRepositoryImpl
import com.maxbay.productsTestEffectiveMobile.data.storage.api.UserStorage
import com.maxbay.productsTestEffectiveMobile.data.storage.db.api.UserDbStorage
import com.maxbay.productsTestEffectiveMobile.data.storage.db.dao.UserDao
import com.maxbay.productsTestEffectiveMobile.repository.AuthRepository
import dagger.Module
import dagger.Provides
import javax.inject.Qualifier

@Module
class RepositoriesModule {
    @Provides
    fun provideAuthRepository(@UserDbStorageClass userStorage: UserStorage): AuthRepository {
        return AuthRepositoryImpl(userStorage = userStorage)
    }

    @Provides
    @UserDbStorageClass
    fun provideUserDbStorage(userDao: UserDao): UserStorage {
        return UserDbStorage(userDao = userDao)
    }
}

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class UserDbStorageClass