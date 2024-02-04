package com.maxbay.presentation.ui.items.favorite

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.maxbay.presentation.R
import com.maxbay.presentation.ui.items.SpacerTopFavoriteItem
import com.maxbay.presentation.ui.values.favoriteIconHeight
import com.maxbay.presentation.ui.values.favoriteIconWidth
import com.maxbay.presentation.ui.values.favoriteItemHeight
import com.maxbay.productsTestEffectiveMobile.ui.ProductsTheme
import kotlinx.collections.immutable.ImmutableList
import testProductUi

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun FavoriteItem(
    isFavorite: Boolean,
    icons: ImmutableList<Int>,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.height(favoriteItemHeight),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.TopEnd
        ) {
            Column(modifier = Modifier.align(Alignment.TopEnd)) {
                SpacerTopFavoriteItem()

                FavoriteIconItem(
                    modifier = Modifier
                        .height(favoriteIconHeight)
                        .width(favoriteIconWidth),
                    isFavorite = isFavorite
                )
            }
        }

        val state = rememberPagerState(
            initialPage = 0,
            pageCount = { icons.size }
        )
        HorizontalPager(
            modifier = Modifier.fillMaxSize(),
            state = state
        ) {
            Image(
                painter = painterResource(id = icons[it]),
                contentDescription = null
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
internal fun FavoriteItemPreview() {
    ProductsTheme{
        FavoriteItem(
            isFavorite = false,
            icons = testProductUi.iconIds
        )
    }
}