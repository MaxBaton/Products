package com.maxbay.productsTestEffectiveMobile.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.maxbay.productsTestEffectiveMobile.data.storage.db.dao.UserDao
import com.maxbay.productsTestEffectiveMobile.data.storage.db.entities.UserEntity

private const val DB_NAME = "Products"
private const val DB_VERSION = 1

@Database(
    version = DB_VERSION,
    entities = [UserEntity::class]
)
abstract class AppDatabase: RoomDatabase() {
    abstract fun userDao(): UserDao

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