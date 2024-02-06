package com.maxbay.presentation.ui.items

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.maxbay.presentation.R
import com.maxbay.presentation.ui.values.btnSignOutHeight
import com.maxbay.presentation.ui.values.cornerDefault
import com.maxbay.presentation.ui.values.paddingBottomBtnSignOut
import com.maxbay.productsTestEffectiveMobile.ui.ProductsTheme

@Composable
fun ButtonSignOutItem(
    onSignOutClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        modifier = modifier
            .fillMaxWidth()
            .height(btnSignOutHeight)
            .background(
                shape = RoundedCornerShape(cornerDefault),
                color = MaterialTheme.colorScheme.onPrimary
            ),
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.onPrimary
        ),
        onClick = onSignOutClick
    ) {
        Text(
            text = stringResource(id = R.string.sign_out),
            style = MaterialTheme.typography.titleSmall,
            color = MaterialTheme.colorScheme.onSurface
        )
    }
}

@Composable
@Preview(showBackground = true)
internal fun ButtonItemPreview() {
    ProductsTheme{
        ButtonSignOutItem(onSignOutClick = {})
    }
}