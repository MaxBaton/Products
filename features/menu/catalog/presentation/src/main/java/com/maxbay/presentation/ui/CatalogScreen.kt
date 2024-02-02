package com.maxbay.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.maxbay.presentation.R
import com.maxbay.presentation.viewModel.CatalogContract
import com.maxbay.productsTestEffectiveMobile.ui.ProductsTheme

@Composable
fun CatalogScreen(
    uiState: CatalogContract.State,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        when(uiState) {
            CatalogContract.State.Fail -> Text(text = "fail")
            CatalogContract.State.Loading -> Text(text = "loading")
            is CatalogContract.State.Success -> {
                LazyColumn {
                    items(uiState.products) {
                        Text(text = it.title)
                    }
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
internal fun CatalogScreenPreview() {
    ProductsTheme {
//        CatalogScreen(modifier = Modifier.background(color = MaterialTheme.colorScheme.primary))
    }
}