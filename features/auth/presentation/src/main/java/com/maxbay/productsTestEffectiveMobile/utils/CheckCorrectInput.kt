package com.maxbay.productsTestEffectiveMobile.utils

private const val MOBILE_PHONE_STR_LENGTH = 10

fun String.isCorrectFirstName(): Boolean = this.isNotBlank() && this.all {
    it.isLetter() && it.code in 0x0400..0x04FF
}

fun String.isCorrectSecondName(): Boolean = this.isCorrectFirstName()

fun String.isCorrectMobilePhone(): Boolean = this.length == MOBILE_PHONE_STR_LENGTH && this.all { it.isDigit() }

fun String.isCorrectMobilePhoneLength(): Boolean = this.length <= MOBILE_PHONE_STR_LENGTH