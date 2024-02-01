package com.maxbay.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.maxbay.presentation.R
import com.maxbay.presentation.ui.ProfileScreen
import com.maxbay.productsTestEffectiveMobile.NavBottomMenuDestination

object ProfileBottomMenuDestination: NavBottomMenuDestination {
    override val iconId: Int = R.drawable.ic_profile
    override val titleId: Int = R.string.profile_screen_title
    override val route: String = "ProfileBottomMenuDestination"
}

fun NavGraphBuilder.profile() {
    composable(route = ProfileBottomMenuDestination.route) {
        ProfileScreen()
    }
}