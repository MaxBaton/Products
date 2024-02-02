package com.maxbay.productsTestEffectiveMobile.di.modules

import android.content.Context
import com.maxbay.productsTestEffectiveMobile.data.storage.db.dao.UserDao
import com.maxbay.productsTestEffectiveMobile.database.AppDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {
    @Provides
    @Singleton
    fun provideAppDatabase(context: Context): AppDatabase {
        return AppDatabase.create(context = context)
    }

    @Provides
    fun provideUserDao(appDatabase: AppDatabase): UserDao {
        return appDatabase.userDao()
    }
}