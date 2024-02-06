package com.maxbay.presentation.navigation

import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.maxbay.presentation.R
import com.maxbay.presentation.di.DaggerProfileComponent
import com.maxbay.presentation.di.ProfileFeatureDepsProvider
import com.maxbay.presentation.ui.ProfileScreen
import com.maxbay.presentation.viewModel.ProfileViewModel
import com.maxbay.productsTestEffectiveMobile.NavBottomMenuDestination

object ProfileBottomMenuDestination: NavBottomMenuDestination {
    override val iconId: Int = R.drawable.ic_profile
    override val titleId: Int = R.string.profile_screen_title
    override val route: String = "ProfileBottomMenuDestination"
}

fun NavGraphBuilder.profile() {
    composable(route = ProfileBottomMenuDestination.route) {
        val profileComponent = DaggerProfileComponent
            .builder()
            .addDeps(deps = ProfileFeatureDepsProvider.deps)
            .build()
        val profileViewModel: ProfileViewModel = viewModel(factory = profileComponent.profileViewModelFactory)
        val uiState by profileViewModel.uiState.collectAsStateWithLifecycle()

        ProfileScreen(
            uiState = uiState,
            onSignOutClick = {}
        )
    }
}