package com.maxbay.presentation.ui.utils

fun String.getPhoneStr(): String {
    return if (this.length == 10) {
        "+7-${this[0]}${this[1]}${this[2]}-${this[3]}${this[4]}${this[5]}" +
                "-${this[6]}${this[7]}-${this[8]}${this[9]}"
    }else {
        this
    }
}