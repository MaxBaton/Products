package com.maxbay.presentation.ui.items

import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.maxbay.presentation.R
import com.maxbay.productsTestEffectiveMobile.ui.ProductsTheme

@Composable
fun FavoriteIconItem(
    isFavorite: Boolean,
    modifier: Modifier = Modifier
) {
    if (isFavorite) {
        Icon(
            modifier = modifier,
            painter = painterResource(id = R.drawable.ic_favorite),
            contentDescription = stringResource(id = R.string.ic_favorite_description),
            tint = MaterialTheme.colorScheme.secondary
        )
    }else {
        Icon(
            modifier = modifier,
            painter = painterResource(id = R.drawable.ic_not_favorite),
            contentDescription = stringResource(id = R.string.ic_not_favorite_description),
            tint = MaterialTheme.colorScheme.onSecondary
        )
    }
}

@Composable
@Preview(showBackground = true)
internal fun FavoriteIconItemPreview() {
    ProductsTheme{
        FavoriteIconItem(isFavorite = false)
    }
}