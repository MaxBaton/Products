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
import com.maxbay.presentation.viewModel.ProfileContract
import com.maxbay.presentation.viewModel.ProfileViewModel
import com.maxbay.productsTestEffectiveMobile.NavBottomMenuDestination
import com.maxbay.productsTestEffectiveMobile.mvi.userEffects

object ProfileBottomMenuDestination: NavBottomMenuDestination {
    override val iconId: Int = R.drawable.ic_profile
    override val titleId: Int = R.string.profile_screen_title
    override val route: String = "ProfileBottomMenuDestination"
}

fun NavGraphBuilder.profile(onSignOut: () -> Unit) {
    composable(route = ProfileBottomMenuDestination.route) {
        val profileComponent = DaggerProfileComponent
            .builder()
            .addDeps(deps = ProfileFeatureDepsProvider.deps)
            .build()
        val profileViewModel: ProfileViewModel = viewModel(factory = profileComponent.profileViewModelFactory)
        val uiState by profileViewModel.uiState.collectAsStateWithLifecycle()

        profileViewModel.userEffects { effect ->
            when(effect) {
                ProfileContract.Effect.None -> Unit
                ProfileContract.Effect.SignOut -> onSignOut()
            }
        }

        ProfileScreen(
            uiState = uiState,
            onSignOutClick = {
                profileViewModel.handleEvent(event = ProfileContract.Event.SignOut)
            }
        )
    }
}