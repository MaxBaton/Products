package com.maxbay.presentation.ui.items

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.tooling.preview.Preview
import com.maxbay.presentation.models.EMPTY_FEEDBACK_COUNT
import com.maxbay.presentation.models.EMPTY_FEEDBACK_RATING
import com.maxbay.presentation.models.ProductUi
import com.maxbay.presentation.ui.values.boxProductItemHeight
import com.maxbay.presentation.ui.values.boxProductItemWidth
import com.maxbay.presentation.ui.values.cornerBoxProductItem
import com.maxbay.presentation.ui.values.elevationBoxProductItem
import com.maxbay.presentation.ui.values.favoriteIconHeight
import com.maxbay.presentation.ui.values.favoriteIconWidth
import com.maxbay.presentation.ui.values.paddingEndIcFavorite
import com.maxbay.presentation.ui.values.paddingHorizontalColumnProductItem
import com.maxbay.presentation.ui.values.paddingHorizontalViewPager
import com.maxbay.presentation.ui.values.paddingTopIcFavorite
import com.maxbay.presentation.ui.values.spaceVerticalBetweenProductItems
import com.maxbay.productsTestEffectiveMobile.ui.ProductsTheme
import testProductUi

private const val SUBTITLE_LINES_COUNT = 3

@Composable
fun ProductItem(
    product: ProductUi,
    onFavoriteClick: (productId: String, isFavorite: Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .height(boxProductItemHeight)
            .shadow(
                elevation = elevationBoxProductItem,
                shape = RoundedCornerShape(size = cornerBoxProductItem)
            )
            .background(
                color = MaterialTheme.colorScheme.primary,
                shape = RoundedCornerShape(size = cornerBoxProductItem)
            )
    ) {
        FavoriteIconItem(
            modifier = Modifier
                .height(favoriteIconHeight)
                .width(favoriteIconWidth)
                .align(Alignment.TopEnd)
                .padding(
                    end = paddingEndIcFavorite,
                    top = paddingTopIcFavorite
                )
                .clickable {
                    onFavoriteClick.invoke(product.id, !product.isFavorite)
                },
            isFavorite = product.isFavorite
        )

        Column(
            modifier = Modifier.padding(horizontal = paddingHorizontalColumnProductItem),
            verticalArrangement = Arrangement.spacedBy(spaceVerticalBetweenProductItems)
        ) {
            IconsViewPagerItem(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = paddingHorizontalViewPager),
                icons = product.iconIds
            )

            OldPriceItem(
                oldPrice = product.oldPrice,
                priceUnit = product.priceUnit
            )

            PriceWithDiscountItem(
                price = product.newPrice,
                unit = product.priceUnit,
                discount = product.priceDiscount
            )

            Text(
                text = product.title,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface
            )

            Text(
                text = product.subtitle,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.surfaceVariant,
                minLines = SUBTITLE_LINES_COUNT,
                maxLines = SUBTITLE_LINES_COUNT
            )

            if (
                product.feedbackCount != EMPTY_FEEDBACK_COUNT
                    && product.feedbackRating != EMPTY_FEEDBACK_RATING
            ) {
                SpacerFeedbackVertical()

                FeedbackItem(
                    rating = product.feedbackRating,
                    count = product.feedbackCount
                )
            }

            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.BottomEnd
            ) {
                AddToCartItem()
            }

        }
    }
}

@Composable
@Preview(showBackground = true)
internal fun ProductItemPreview() {
    ProductsTheme {
        ProductItem(
            modifier = Modifier
                .height(boxProductItemHeight)
                .width(boxProductItemWidth),
            product = testProductUi,
            onFavoriteClick = { _, _ -> }
        )
    }
}