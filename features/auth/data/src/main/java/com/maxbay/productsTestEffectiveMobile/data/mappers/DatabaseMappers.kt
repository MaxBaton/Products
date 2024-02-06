package com.maxbay.productsTestEffectiveMobile.data.mappers

import com.maxbay.productsTestEffectiveMobile.data.storage.db.dto.UserDto
import com.maxbay.productsTestEffectiveMobile.data.storage.db.entities.UserEntity
import com.maxbay.productsTestEffectiveMobile.data.storage.models.UserModelStorage
import com.maxbay.productsTestEffectiveMobile.models.User
import com.maxbay.productsTestEffectiveMobile.models.UserSignUp

internal fun UserModelStorage.toEntity() = UserEntity(
    id = this.id,
    firstName = this.firstName,
    secondName = this.secondName,
    mobilePhone = this.mobilePhone
)

internal fun UserSignUp.toStorage() = UserModelStorage(
    firstName = this.firstName,
    secondName = this.secondName,
    mobilePhone = this.mobilePhone
)

internal fun UserDto.toStorage() = UserModelStorage(
    id = this.id,
    firstName = this.firstName,
    secondName = this.secondName,
    mobilePhone = this.mobilePhone
)

internal fun UserModelStorage.toDomain() = User(
    id = this.id,
    firstName = this.firstName,
    secondName = this.secondName,
    mobilePhone = this.mobilePhone
)