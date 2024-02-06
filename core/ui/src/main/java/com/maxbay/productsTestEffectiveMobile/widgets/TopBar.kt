package com.maxbay.productsTestEffectiveMobile.widgets

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.maxbay.productsTestEffectiveMobile.ui.ProductsTheme
import com.maxbay.productsTestEffectiveMobile.ui.topBarPaddingHorizontal
import com.maxbay.productsTestEffectiveMobile.ui.zeroVal

@ExperimentalMaterial3Api
@Composable
fun TopBar(
    title: String
) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = title,
                maxLines = 1,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onSurface,
                overflow = TextOverflow.Ellipsis
            )
        },
        windowInsets = WindowInsets(
            left = topBarPaddingHorizontal,
            right = topBarPaddingHorizontal,
            top = zeroVal,
            bottom = zeroVal
        ),
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary
        )
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview(showBackground = true)
fun TopBarPreview() {
    ProductsTheme {
        TopBar(title = "Title")
    }
}