package com.maxbay.productsTestEffectiveMobile.presentation.viewModel

import androidx.lifecycle.ViewModel
import com.maxbay.productsTestEffectiveMobile.NavBottomMenuDestination
import com.maxbay.productsTestEffectiveMobile.NavBottomMenuDestinationsCollection
import com.maxbay.productsTestEffectiveMobile.presentation.ui.models.BottomMenuUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class MenuViewModel(
    private val bottomMenuDestinationCollection: NavBottomMenuDestinationsCollection
): ViewModel() {
    private val _uiState = MutableStateFlow(BottomMenuUiState(destinations = bottomMenuDestinationCollection.destinations))
    val uiState: StateFlow<BottomMenuUiState> = _uiState.asStateFlow()

    init {
        val d = bottomMenuDestinationCollection.destinations
        val s = d.size
    }
}