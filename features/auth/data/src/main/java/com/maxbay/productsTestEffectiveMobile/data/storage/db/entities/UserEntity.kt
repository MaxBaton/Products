package com.maxbay.productsTestEffectiveMobile.data.storage.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = UserEntity.TABLE_NAME)
data class UserEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = ID)
    val id: Int = 0,
    @ColumnInfo(name = FIRST_NAME)
    val firstName: String,
    @ColumnInfo(name = SECOND_NAME)
    val secondName: String,
    @ColumnInfo(name = MOBILE_PHONE)
    val mobilePhone: String
) {
    companion object {
        const val TABLE_NAME = "UserEntity"
        const val ID = "id"
        const val FIRST_NAME = "first_name"
        const val SECOND_NAME = "second_name"
        const val MOBILE_PHONE = "mobile_phone"
    }
}
