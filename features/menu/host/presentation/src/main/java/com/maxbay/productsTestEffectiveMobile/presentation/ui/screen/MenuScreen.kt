package com.maxbay.productsTestEffectiveMobile.presentation.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.maxbay.presentation.navigation.cart
import com.maxbay.presentation.navigation.catalog
import com.maxbay.presentation.navigation.discounts
import com.maxbay.presentation.navigation.profile
import com.maxbay.productsTestEffectiveMobile.navigateSingleTop
import com.maxbay.productsTestEffectiveMobile.presentation.navigation.MainBottomMenuDestination
import com.maxbay.productsTestEffectiveMobile.presentation.navigation.main
import com.maxbay.productsTestEffectiveMobile.presentation.ui.models.BottomMenuUiState
import com.maxbay.productsTestEffectiveMobile.presentation.ui.widget.NavBar

@Composable
fun MenuScreen(
    uiState: BottomMenuUiState,
    modifier: Modifier = Modifier
) {
    val navController: NavHostController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination?.route

    Scaffold(
        bottomBar = {
            NavBar(
                modifier = Modifier.background(color = MaterialTheme.colorScheme.background),
                currentDestination = currentDestination,
                destinations = uiState.destinations,
                onNavigateToTopLevel = { route ->
                    navController.navigateSingleTop(route = route)
                }
            )
        }
    ) { innerPaddings ->
        Box(modifier = Modifier.fillMaxWidth().padding(paddingValues = innerPaddings)) {
            NavHost(
                navController = navController,
                startDestination = MainBottomMenuDestination.route
            ) {
                main()
                catalog()
                cart()
                discounts()
                profile()
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun MenuScreenPreview() {
//    val bottomMenuUiState = getTestBottomMenuUiStateForPreview()
//
//    KiparoPizzaAppTheme {
//        MenuScreen(
//            uiState = bottomMenuUiState,
//            onItemClick = {},
//            onLogoutClick = {}
//        )
//    }
}