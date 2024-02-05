package com.maxbay.presentation.ui.items

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.maxbay.presentation.R
import com.maxbay.presentation.ui.values.addToCartItemHeight
import com.maxbay.presentation.ui.values.addToCartItemWidth
import com.maxbay.productsTestEffectiveMobile.ui.ProductsTheme

@Composable
fun AddToCartItem(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .height(addToCartItemHeight)
            .width(addToCartItemWidth)
            .background(color = MaterialTheme.colorScheme.secondary),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_add_to_cart),
            contentDescription = stringResource(id = R.string.ic_add_to_cart_description),
            tint = MaterialTheme.colorScheme.primary
        )
    }
}

@Composable
@Preview(showBackground = true)
internal fun AddToCartItemPreview() {
    ProductsTheme{
        AddToCartItem()
    }
}