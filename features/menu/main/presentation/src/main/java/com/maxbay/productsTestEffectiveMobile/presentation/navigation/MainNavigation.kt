package com.maxbay.productsTestEffectiveMobile.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.maxbay.productsTestEffectiveMobile.NavBottomMenuDestination
import com.maxbay.productsTestEffectiveMobile.presentation.R
import com.maxbay.productsTestEffectiveMobile.presentation.ui.MainScreen

object MainBottomMenuDestination: NavBottomMenuDestination {
    override val iconId: Int = R.drawable.ic_main
    override val titleId: Int = R.string.main_screen_title
    override val route: String = "MainBottomMenuDestination"
}

fun NavGraphBuilder.main() {
    composable(route = MainBottomMenuDestination.route) {
        MainScreen()
    }
}