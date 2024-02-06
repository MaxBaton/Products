package com.maxbay.productsTestEffectiveMobile.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.maxbay.productsTestEffectiveMobile.di.AppComponentProvider
import com.maxbay.productsTestEffectiveMobile.presentation.navigation.MENU_GRAPH
import com.maxbay.productsTestEffectiveMobile.presentation.navigation.menu
import com.maxbay.productsTestEffectiveMobile.presentation.navigation.navigateToMenu
import com.maxbay.productsTestEffectiveMobile.viewModel.AppViewModel
import com.maxbay.productsTestEffectiveMobile.viewModel.ERROR_USER_ID

@Composable
fun AppNavHost(navController: NavHostController = rememberNavController()) {
    val appViewModel: AppViewModel = viewModel(factory = AppComponentProvider.appComponent.appViewModelFactory)
    val registerUserId by appViewModel.registerUserIdState.collectAsStateWithLifecycle()
    if (registerUserId != null) {
        val startDestination = if (registerUserId == ERROR_USER_ID) {
            AuthNavDestination.route
        }else {
            MENU_GRAPH
        }

        NavHost(
            navController = navController,
            startDestination = startDestination
        ) {
            auth(onNavigateToMenu = navController::navigateToMenu)
            menu(onSignOut = navController::navigateToAuth)
        }
    }
}