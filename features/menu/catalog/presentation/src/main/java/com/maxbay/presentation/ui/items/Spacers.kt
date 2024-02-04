package com.maxbay.presentation.ui.items

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.maxbay.presentation.ui.values.paddingTopIcFavorite

@Composable
fun Spacer16() {
    Spacer(modifier = Modifier.height(16.dp))
}

@Composable
fun SpacerFeedbackVertical() {
    Spacer(modifier = Modifier.height(4.dp))
}

@Composable
fun SpacerTopFavoriteItem() {
    Spacer(modifier = Modifier.height(paddingTopIcFavorite))
}