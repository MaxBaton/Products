package com.maxbay.presentation.ui.items

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.maxbay.presentation.R
import com.maxbay.presentation.ui.values.cornerBoxProductItem
import com.maxbay.presentation.ui.values.paddingHorizontalBoxDiscount
import com.maxbay.presentation.ui.values.paddingVerticalBoxDiscount
import com.maxbay.presentation.ui.values.spaceBetweenPriceDiscountItems
import com.maxbay.productsTestEffectiveMobile.ui.ProductsTheme

@Composable
fun PriceWithDiscountItem(
    price: String,
    unit: String,
    discount: Int,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(spaceBetweenPriceDiscountItems),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = stringResource(id = R.string.price_str, price, unit),
            style = MaterialTheme.typography.titleSmall,
            color = MaterialTheme.colorScheme.onSurface
        )

        Box(
            modifier = Modifier
                .background(
                    shape = RoundedCornerShape(size = cornerBoxProductItem),
                    color = MaterialTheme.colorScheme.secondary
                )
                .padding(
                    start = paddingHorizontalBoxDiscount,
                    end = paddingHorizontalBoxDiscount,
                    top = paddingVerticalBoxDiscount,
                    bottom = paddingVerticalBoxDiscount
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = stringResource(id = R.string.discount_str, discount),
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.primary
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
internal fun PriceWithDiscountItemPreview() {
    ProductsTheme{
        PriceWithDiscountItem(
            price = "23",
            unit = "$",
            discount = 35
        )
    }
}