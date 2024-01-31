package com.maxbay.productsTestEffectiveMobile.navigation

import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.maxbay.productsTestEffectiveMobile.NavDestination
import com.maxbay.productsTestEffectiveMobile.models.UserSignUp
import com.maxbay.productsTestEffectiveMobile.mvi.userEffects
import com.maxbay.productsTestEffectiveMobile.repository.AuthRepository
import com.maxbay.productsTestEffectiveMobile.ui.screen.AuthScreen
import com.maxbay.productsTestEffectiveMobile.useCase.SignUpUserUseCase
import com.maxbay.productsTestEffectiveMobile.viewModel.AuthContract
import com.maxbay.productsTestEffectiveMobile.viewModel.AuthViewModel
import com.maxbay.productsTestEffectiveMobile.viewModel.AuthViewModelFactory

object AuthNavDestination: NavDestination {
    override val route: String = "AuthNavDestination"
}

private const val EMPTY = ""

fun NavGraphBuilder.auth(onNavigateToMenu: () -> Unit) {
    composable(route = AuthNavDestination.route) {
        val authViewModel: AuthViewModel = viewModel(
            factory = AuthViewModelFactory(signUpUserUseCase = SignUpUserUseCase(object: AuthRepository {
                override suspend fun signUp(userSignUp: UserSignUp) {
                    //
                }
            }))
        )
        val uiState by authViewModel.uiState.collectAsStateWithLifecycle()

        authViewModel.userEffects { effect ->
            when(effect) {
                AuthContract.Effect.None -> Unit
                AuthContract.Effect.SignUp -> onNavigateToMenu()
            }
        }

        AuthScreen(
            uiState = uiState,
            onFirstNameChange = { firstName ->
                authViewModel.handleEvent(event = AuthContract.Event.FistNameChange(firstName = firstName))
            },
            onSecondNameChange = { secondName ->
                authViewModel.handleEvent(event = AuthContract.Event.SecondNameChange(secondName = secondName))
            },
            onMobilePhoneChange = { mobilePhone ->
                authViewModel.handleEvent(event = AuthContract.Event.MobilePhoneChange(mobilePhone = mobilePhone))
            },
            onClearFirstName = {
                authViewModel.handleEvent(event = AuthContract.Event.FistNameChange(firstName = EMPTY))
            },
            onClearSecondName = {
                authViewModel.handleEvent(event = AuthContract.Event.SecondNameChange(secondName = EMPTY))
            },
            onClearMobilePhone = {
                authViewModel.handleEvent(event = AuthContract.Event.MobilePhoneChange(mobilePhone = EMPTY))
            },
            onSignUp = {
                authViewModel.handleEvent(event = AuthContract.Event.SignUp)
            }
        )
    }
}