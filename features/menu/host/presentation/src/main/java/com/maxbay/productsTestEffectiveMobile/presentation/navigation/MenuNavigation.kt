package com.maxbay.productsTestEffectiveMobile.presentation.navigation

import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.maxbay.productsTestEffectiveMobile.NavBottomMenuDestinationsCollection
import com.maxbay.productsTestEffectiveMobile.NavDestination
import com.maxbay.productsTestEffectiveMobile.presentation.di.DaggerMenuComponent
import com.maxbay.productsTestEffectiveMobile.presentation.ui.screen.MenuScreen
import com.maxbay.productsTestEffectiveMobile.presentation.viewModel.MenuViewModel
import com.maxbay.productsTestEffectiveMobile.presentation.viewModel.MenuViewModelFactory

const val MENU_GRAPH = "MENU_GRAPH"

fun NavGraphBuilder.menu(onSignOut: () -> Unit) {
    navigation(
        route = MENU_GRAPH,
        startDestination = MenuDestination.route
    ) {
        bottomMenuInner(onSignOut = onSignOut)
    }
}

private fun NavGraphBuilder.bottomMenuInner(onSignOut: () -> Unit) {
    composable(route = MenuDestination.route) {
        val menuComponent = DaggerMenuComponent
            .builder()
            .build()

        val menuViewModel: MenuViewModel = viewModel(
            factory = MenuViewModelFactory(bottomMenuDestinationCollection = NavBottomMenuDestinationsCollection(
                destinations = menuComponent.bottomMenuDestinations.destinations
            ))
        )
        val bottomMenuUiState by menuViewModel.uiState.collectAsStateWithLifecycle()

        MenuScreen(
            uiState = bottomMenuUiState,
            onSignOut = onSignOut
        )
    }
}

object MenuDestination: NavDestination {
    override val route: String = "MenuDestination"
}

fun NavHostController.navigateToMenu() {
    popBackStack()
    navigate(route = MenuDestination.route) {
        popUpTo(route = MainBottomMenuDestination.route) {
            inclusive = true
        }
    }
}