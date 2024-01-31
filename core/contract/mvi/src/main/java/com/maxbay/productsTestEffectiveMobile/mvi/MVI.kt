package com.maxbay.productsTestEffectiveMobile.mvi

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import kotlinx.coroutines.flow.StateFlow

interface UnidirectionalViewModel<EVENT, STATE, EFFECT> {
    val uiState: StateFlow<STATE>
    val effect: StateFlow<EFFECT>
    fun handleEvent(event: EVENT)
    fun consume()
}

@SuppressLint("ComposableNaming")
@Composable
fun <EVENT, STATE, EFFECT> UnidirectionalViewModel<EVENT, STATE, EFFECT>.userEffects(function: (value: EFFECT) -> Unit) {
    val key by effect.collectAsStateWithLifecycle()

    DisposableEffect(key) {
        key?.let{ localEffect ->
            function(localEffect)
        }

        onDispose {
            consume()
        }
    }
}