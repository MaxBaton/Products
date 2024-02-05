package com.maxbay.productsTestEffectiveMobile.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.maxbay.data.storage.db.dao.ProductDao
import com.maxbay.data.storage.db.entities.ProductIsFavoriteEntity
import com.maxbay.productsTestEffectiveMobile.data.storage.db.dao.UserDao
import com.maxbay.productsTestEffectiveMobile.data.storage.db.entities.UserEntity

private const val DB_NAME = "Products.db"
private const val DB_VERSION = 2

@Database(
    version = DB_VERSION,
    entities = [UserEntity::class, ProductIsFavoriteEntity::class],
    exportSchema = false
)
abstract class AppDatabase: RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun productDao(): ProductDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null
        private val LOCK = Any()

        fun create(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(LOCK) {
                val db = Room.databaseBuilder(
                    context = context,
                    klass = AppDatabase::class.java,
                    name = DB_NAME
                )
                    .fallbackToDestructiveMigration()
                    .build()

                INSTANCE = db

                db
            }
        }
    }
}