package com.maxbay.presentation.ui.items

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.maxbay.presentation.models.ProductUi
import com.maxbay.productsTestEffectiveMobile.ui.ProductsTheme

@Composable
fun ProductItem(
    product: ProductUi,
    modifier: Modifier = Modifier
) {
    Text(text = product.title)
}

@Composable
@Preview(showBackground = true)
internal fun ProductItemPreview() {
    ProductsTheme {
//        ProductItem()
    }
}