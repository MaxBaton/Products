package com.maxbay.presentation.ui.items

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.maxbay.presentation.models.ProductUi
import com.maxbay.productsTestEffectiveMobile.ui.ProductsTheme

@Composable
fun ProductItem(
    product: ProductUi,
    onFavoriteClick: (productId: String, isFavorite: Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    val isFavoriteStr = if (product.isFavorite) {
        "remove to favorite"
    }else {
        "add from favorite"
    }
    Column {
        Text(
            text = product.title,
            color = if (product.isFavorite) {
                MaterialTheme.colorScheme.secondary
            }else {
                MaterialTheme.colorScheme.surface
            }
        )
        Text(
            modifier = Modifier.clickable {
                onFavoriteClick.invoke(product.id, !product.isFavorite)
            },
            text = isFavoriteStr
        )
    }
}

@Composable
@Preview(showBackground = true)
internal fun ProductItemPreview() {
    ProductsTheme {
//        ProductItem()
    }
}