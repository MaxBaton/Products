package com.maxbay.productsTestEffectiveMobile

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController

data class NavBottomMenuDestinationsCollection(
    val destinations: List<NavBottomMenuDestination>
)

interface NavDestination {
    val route: String
}

interface NavBottomMenuDestination: NavDestination {
    @get:DrawableRes
    val iconId: Int
    @get:StringRes
    val titleId: Int
}

fun NavHostController.navigateSingleTop(route: String) {
    navigate(route = route) {
        popUpTo(id = this@navigateSingleTop.graph.findStartDestination().id) {
            saveState = true
        }
        launchSingleTop = true
        restoreState = true
    }
}