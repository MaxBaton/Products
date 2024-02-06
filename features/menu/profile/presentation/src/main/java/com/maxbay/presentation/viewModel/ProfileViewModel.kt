package com.maxbay.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maxbay.api.AuthApi
import com.maxbay.productsTestEffectiveMobile.useCase.GetRegisterUserUseCase
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ProfileViewModel(
    private val getRegisterUserUseCase: GetRegisterUserUseCase
): ViewModel(), ProfileContract {
    private val _uiState = MutableStateFlow<ProfileContract.State>(ProfileContract.State.Loading)
    override val uiState: StateFlow<ProfileContract.State> = _uiState.asStateFlow()

    private val _effect = MutableStateFlow<ProfileContract.Effect>(ProfileContract.Effect.None)
    override val effect: StateFlow<ProfileContract.Effect> = _effect.asStateFlow()


    init {
        getRegisterUser()
    }

    private fun getRegisterUser() {
        val exceptionHandler = CoroutineExceptionHandler { _, _ ->
            ProfileContract.State.Fail
        }

        viewModelScope.launch(exceptionHandler) {
            val user = getRegisterUserUseCase.execute()
            _uiState.update {
                ProfileContract.State.Success(user = user, favoritesCount = 1)
            }
        }
    }

    override fun handleEvent(event: ProfileContract.Event) {
        when(event) {
            is ProfileContract.Event.SignOut -> onSignOut(userId = event.userId)
        }
    }

    override fun consume() {
        _effect.update {
            ProfileContract.Effect.None
        }
    }

    private fun onSignOut(userId: Int) {

    }
}