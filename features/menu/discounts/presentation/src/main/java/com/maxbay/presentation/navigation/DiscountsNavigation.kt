package com.maxbay.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.maxbay.presentation.R
import com.maxbay.presentation.ui.DiscountsScreen
import com.maxbay.productsTestEffectiveMobile.NavBottomMenuDestination

object DiscountsBottomMenuDestination: NavBottomMenuDestination {
    override val iconId: Int = R.drawable.ic_discount
    override val titleId: Int = R.string.discounts_screen_title
    override val route: String = "DiscountsBottomMenuDestination"
}

fun NavGraphBuilder.discounts() {
    composable(route = DiscountsBottomMenuDestination.route) {
        DiscountsScreen()
    }
}