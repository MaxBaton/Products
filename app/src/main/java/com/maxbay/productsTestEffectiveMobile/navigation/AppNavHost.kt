package com.maxbay.productsTestEffectiveMobile.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.maxbay.productsTestEffectiveMobile.presentation.navigation.menu
import com.maxbay.productsTestEffectiveMobile.presentation.navigation.navigateToMenu

@Composable
fun AppNavHost(navController: NavHostController = rememberNavController()) {
    NavHost(
        navController = navController,
        startDestination = AuthNavDestination.route
    ) {
        auth(onNavigateToMenu = navController::navigateToMenu)
        menu()
    }
}