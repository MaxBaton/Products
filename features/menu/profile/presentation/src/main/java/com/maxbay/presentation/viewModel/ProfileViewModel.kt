package com.maxbay.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maxbay.api.AuthApi
import com.maxbay.domain.usecase.ObserveFavoritesCountUseCase
import com.maxbay.productsTestEffectiveMobile.useCase.GetRegisterUserUseCase
import com.maxbay.productsTestEffectiveMobile.useCase.SignOutUseCase
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ProfileViewModel(
    private val getRegisterUserUseCase: GetRegisterUserUseCase,
    private val signOutUseCase: SignOutUseCase,
    private val observeFavoritesCountUseCase: ObserveFavoritesCountUseCase
): ViewModel(), ProfileContract {
    private val _uiState = MutableStateFlow<ProfileContract.State>(ProfileContract.State.Loading)
    override val uiState: StateFlow<ProfileContract.State> = _uiState.asStateFlow()

    private val _effect = MutableStateFlow<ProfileContract.Effect>(ProfileContract.Effect.None)
    override val effect: StateFlow<ProfileContract.Effect> = _effect.asStateFlow()


    init {
        getRegisterUser()
        observeFavoritesCount()
    }

    private fun getRegisterUser() {
        val exceptionHandler = CoroutineExceptionHandler { _, _ ->
            ProfileContract.State.Fail
        }

        viewModelScope.launch(exceptionHandler) {
            val user = getRegisterUserUseCase.execute()
            _uiState.update { currentState ->
                if (currentState is ProfileContract.State.Success) {
                    currentState.copy(user = user)
                }else {
                    ProfileContract.State.Success(
                        user = user,
                        favoritesCount = ProfileContract.State.Success.initialFavoritesCount()
                    )
                }
            }
        }
    }

    private fun observeFavoritesCount() {
        viewModelScope.launch {
            observeFavoritesCountUseCase.execute().collect { count ->
                _uiState.update { currentState ->
                    if (currentState is ProfileContract.State.Success) {
                        currentState.copy(favoritesCount = count)
                    }else {
                        ProfileContract.State.Success(
                            user = ProfileContract.State.Success.initialUser(),
                            favoritesCount = count
                        )
                    }
                }
            }
        }
    }

    override fun handleEvent(event: ProfileContract.Event) {
        when(event) {
            ProfileContract.Event.SignOut -> onSignOut()
        }
    }

    override fun consume() {
        _effect.update {
            ProfileContract.Effect.None
        }
    }

    private fun onSignOut() {
        viewModelScope.launch {
            if (_uiState.value is ProfileContract.State.Success) {
                val exceptionHandler = CoroutineExceptionHandler { _, _ ->
                    //
                }

                signOutUseCase.execute(userId = (_uiState.value as ProfileContract.State.Success).user.id)
                _effect.update {
                    ProfileContract.Effect.SignOut
                }
            }
        }
    }
}