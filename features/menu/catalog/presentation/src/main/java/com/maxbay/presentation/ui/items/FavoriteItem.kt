package com.maxbay.presentation.ui.items

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.maxbay.presentation.R
import com.maxbay.presentation.ui.values.favoriteIconHeight
import com.maxbay.presentation.ui.values.favoriteIconWidth
import com.maxbay.presentation.ui.values.favoriteItemHeight
import com.maxbay.productsTestEffectiveMobile.ui.ProductsTheme

@Composable
fun FavoriteItem(
    isFavorite: Boolean,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.height(20.dp)
    ) {
        if (isFavorite) {
            Icon(
                modifier = Modifier
                    .height(favoriteIconHeight)
                    .width(favoriteIconWidth),
                painter = painterResource(id = R.drawable.ic_favorite),
                contentDescription = stringResource(id = R.string.ic_favorite_description),
                tint = MaterialTheme.colorScheme.secondary
            )
        }else {
            Icon(
                modifier = Modifier
                    .height(favoriteIconHeight)
                    .width(favoriteIconWidth),
                painter = painterResource(id = R.drawable.ic_not_favorite),
                contentDescription = stringResource(id = R.string.ic_not_favorite_description),
                tint = MaterialTheme.colorScheme.onSecondary
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
internal fun FavoriteItemPreview() {
    ProductsTheme{
        FavoriteItem(
            isFavorite = false
        )
    }
}