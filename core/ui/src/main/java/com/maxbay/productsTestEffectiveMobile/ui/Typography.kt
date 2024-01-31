package com.maxbay.productsTestEffectiveMobile.ui

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

val typography = Typography(
    titleLarge = TextStyle(
        fontFamily = sfProDisplayFontFamily,
        fontSize = 20.sp,
        lineHeight = 26.sp,
        fontWeight = FontWeight.W500
    ),
    titleMedium = TextStyle(
        fontFamily = sfProDisplayFontFamily,
        fontSize = 16.sp,
        lineHeight = 20.8.sp,
        fontWeight = FontWeight.W500
    ),
    titleSmall = TextStyle(
        fontFamily = sfProDisplayFontFamily,
        fontSize = 14.sp,
        lineHeight = 18.2.sp,
        fontWeight = FontWeight.W500
    )
)