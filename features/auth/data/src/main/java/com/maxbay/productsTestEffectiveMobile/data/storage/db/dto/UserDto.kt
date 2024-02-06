package com.maxbay.productsTestEffectiveMobile.data.storage.db.dto

import androidx.room.ColumnInfo

data class UserDto(
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
        const val ID = "id_user_dto"
        const val FIRST_NAME = "first_name_user_dto"
        const val SECOND_NAME = "second_name_user_dto"
        const val MOBILE_PHONE = "mobile_phone_user_dto"
    }
}
