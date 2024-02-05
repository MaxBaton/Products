package com.maxbay.presentation.ui.items.favorite

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.maxbay.presentation.ui.values.favoriteItemHeight
import com.maxbay.presentation.ui.values.indicatorSize
import com.maxbay.presentation.ui.values.paddingIndicator
import com.maxbay.productsTestEffectiveMobile.ui.ProductsTheme
import kotlinx.collections.immutable.ImmutableList
import testProductUi

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun IconsViewPagerItem(
    icons: ImmutableList<Int>,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.height(favoriteItemHeight),
        contentAlignment = Alignment.Center
    ) {
        val pagerState = rememberPagerState(
            initialPage = 0,
            pageCount = { icons.size }
        )
        HorizontalPager(
            modifier = Modifier
                .wrapContentHeight()
                .align(Alignment.TopCenter),
            state = pagerState
        ) {
            Image(
                painter = painterResource(id = icons[it]),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
        }
        Row(
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            horizontalArrangement = Arrangement.Center
        ) {
            repeat(pagerState.pageCount) { iteration ->
                val color = if (pagerState.currentPage == iteration) {
                    MaterialTheme.colorScheme.secondary
                }else {
                    MaterialTheme.colorScheme.inverseSurface
                }

                Box(
                    modifier = Modifier
                        .padding(paddingIndicator)
                        .clip(CircleShape)
                        .background(color)
                        .size(indicatorSize)
                )
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
internal fun IconsViewPagerItemPreview() {
    ProductsTheme{
        IconsViewPagerItem(
            modifier = Modifier
                .width(100.dp)
                .height(76.dp),
            icons = testProductUi.iconIds
        )
    }
}