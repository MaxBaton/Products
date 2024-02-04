package com.maxbay.productsTestEffectiveMobile.ui

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val lightColorScheme = lightColorScheme(
    primary = White,
    onPrimary = LightGrey,
    secondary = Pink,
    onSecondary = LightPink,
    tertiary = Orange,
    surface = Grey,
    surfaceVariant = DarkGrey,
    onSurface = Black,
    onSurfaceVariant = DarkBlue,
    inverseSurface = KinglyCloud,
    error = Red
)

private val darkColorScheme = darkColorScheme(
    primary = White,
    onPrimary = LightGrey,
    secondary = Pink,
    onSecondary = LightPink,
    tertiary = Orange,
    surface = Grey,
    surfaceVariant = DarkGrey,
    onSurface = Black,
    onSurfaceVariant = DarkBlue,
    inverseSurface = KinglyCloud,
    error = Red
)

@Composable
fun ProductsTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        darkTheme -> darkColorScheme
        else -> lightColorScheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme, typography = typography, content = content
    )
}