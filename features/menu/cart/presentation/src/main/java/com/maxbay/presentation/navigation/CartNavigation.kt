package com.maxbay.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.maxbay.presentation.R
import com.maxbay.presentation.ui.CartScreen
import com.maxbay.productsTestEffectiveMobile.NavBottomMenuDestination

object CartBottomMenuDestination: NavBottomMenuDestination {
    override val iconId: Int = R.drawable.ic_cart
    override val titleId: Int = R.string.cart_screen_title
    override val route: String = "CartBottomMenuDestination"
}

fun NavGraphBuilder.cart() {
    composable(route = CartBottomMenuDestination.route) {
        CartScreen()
    }
}