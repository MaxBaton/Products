package com.maxbay.productsTestEffectiveMobile.utils

fun String.isCorrectFirstName(): Boolean = this.isNotBlank() && this.all {
    it.isLetter() && it.code in 0x0400..0x04FF
}

fun String.isCorrectSecondName(): Boolean = this.isCorrectFirstName()

fun String.isCorrectMobilePhone(): Boolean = this.isNotBlank()//matches("7-d{7}".toRegex())