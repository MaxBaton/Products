package com.maxbay.productsTestEffectiveMobile.utils

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun Boolean.getColorByEnabled(): Color {
    return if (this) {
        MaterialTheme.colorScheme.secondary
    }else {
        MaterialTheme.colorScheme.onSecondary
    }
}