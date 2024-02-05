package com.maxbay.productsTestEffectiveMobile.ui.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.maxbay.productsTestEffectiveMobile.presentation.R
import com.maxbay.productsTestEffectiveMobile.ui.ProductsTheme
import com.maxbay.productsTestEffectiveMobile.ui.values.buttonCorner

@Composable
fun RoundButton(
    isEnable: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        modifier = modifier
            .background(
                shape = RoundedCornerShape(buttonCorner),
                color = if (isEnable) {
                    MaterialTheme.colorScheme.secondary
                }else {
                    MaterialTheme.colorScheme.onSecondary
                }
            )
            .fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            containerColor = if (isEnable) {
                MaterialTheme.colorScheme.secondary
            }else {
                MaterialTheme.colorScheme.onSecondary
            }
        ),
        onClick = onClick
    ) {
        Text(
            text = stringResource(id = R.string.sign_in),
            style = MaterialTheme.typography.titleSmall,
            color = MaterialTheme.colorScheme.primary
        )
    }
}

@Composable
@Preview(showBackground = true)
internal fun RoundButtonPreview() {
    ProductsTheme {
        RoundButton(
            isEnable = true,
            onClick = {}
        )
    }
}