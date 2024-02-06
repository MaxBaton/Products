package com.maxbay.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.maxbay.presentation.R
import com.maxbay.presentation.viewModel.ProfileContract
import com.maxbay.productsTestEffectiveMobile.ui.ProductsTheme

@Composable
fun ProfileScreen(
    uiState: ProfileContract.State,
    modifier: Modifier = Modifier
) {
    when(uiState) {
        ProfileContract.State.Fail -> {}
        ProfileContract.State.Loading -> {}
        is ProfileContract.State.Success -> {
            Column {
                Text(text = "${uiState.user.firstName}\n${uiState.user.secondName}")
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
internal fun ProfileScreenPreview() {
    ProductsTheme {
//        ProfileScreen(modifier = Modifier.background(color = MaterialTheme.colorScheme.primary))
    }
}