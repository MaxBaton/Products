package com.maxbay.presentation.ui.items

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import com.maxbay.presentation.R
import com.maxbay.productsTestEffectiveMobile.ui.ProductsTheme
import testProductUi

@Composable
fun OldPriceItem(
    oldPrice: String,
    priceUnit: String,
    modifier: Modifier = Modifier
) {
    val text = stringResource(id = R.string.price_str, oldPrice, priceUnit)

    val annotatedString = AnnotatedString.Builder()
        .apply {
            withStyle(
                style = SpanStyle(
                    textDecoration = TextDecoration.LineThrough
                )
            ) {
                append(text)
            }
        }
        .toAnnotatedString()

    Text(
        text = annotatedString,
        style = MaterialTheme.typography.labelSmall,
        color = MaterialTheme.colorScheme.surface
    )
}

@Composable
@Preview(showBackground = true)
internal fun OldPriceItemPreview() {
    ProductsTheme{
        OldPriceItem(
            oldPrice = testProductUi.oldPrice,
            priceUnit = testProductUi.priceUnit
        )
    }
}