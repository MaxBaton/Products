package com.maxbay.presentation.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
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