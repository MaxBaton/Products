package com.maxbay.productsTestEffectiveMobile.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maxbay.productsTestEffectiveMobile.useCase.GetRegisterUserIdUseCase
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

internal const val ERROR_USER_ID = -1
private const val ZERO_INT_VALUE = 0

class AppViewModel(
    private val getRegisterUserIdUseCase: GetRegisterUserIdUseCase
): ViewModel() {
    private val _registerUserIdState = MutableStateFlow<Int?>(null)
    val registerUserIdState: StateFlow<Int?> = _registerUserIdState.asStateFlow()

    init {
        getRegisterUserId()
    }

    private fun getRegisterUserId() {
        val exceptionHandler = CoroutineExceptionHandler { _, _ ->
            _registerUserIdState.update { ERROR_USER_ID }
        }

        viewModelScope.launch(exceptionHandler) {
            val idUseCase = getRegisterUserIdUseCase.execute()
            val id = if (idUseCase > ZERO_INT_VALUE) idUseCase else ERROR_USER_ID
            _registerUserIdState.update { id }
        }
    }
}