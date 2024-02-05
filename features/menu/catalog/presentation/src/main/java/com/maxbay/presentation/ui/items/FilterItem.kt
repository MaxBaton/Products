package com.maxbay.presentation.ui.items

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.maxbay.presentation.R
import com.maxbay.presentation.ui.values.spaceFilterText
import com.maxbay.productsTestEffectiveMobile.ui.ProductsTheme

@Composable
fun FilterItem(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_filters),
            contentDescription = stringResource(id = R.string.ic_favorite_description),
            tint = Color.Unspecified
        )

        Spacer(modifier = Modifier.width(spaceFilterText))

        Text(
            text = stringResource(id = R.string.filters),
            style = MaterialTheme.typography.titleSmall,
            color = MaterialTheme.colorScheme.surfaceVariant
        )
    }
}

@Composable
@Preview(showBackground = true)
internal fun FilterItemPreview() {
    ProductsTheme{
        FilterItem()
    }
}