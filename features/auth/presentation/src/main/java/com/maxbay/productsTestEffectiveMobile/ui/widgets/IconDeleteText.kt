package com.maxbay.productsTestEffectiveMobile.ui.widgets

import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.maxbay.productsTestEffectiveMobile.presentation.R

@Composable
fun IconDeleteText(onClick: () -> Unit) {
    IconButton(onClick = onClick) {
        Icon(
            painter = painterResource(id = R.drawable.ic_clear_text),
            contentDescription = stringResource(id = R.string.ic_close_description),
            tint = Color.Unspecified
        )
    }
}