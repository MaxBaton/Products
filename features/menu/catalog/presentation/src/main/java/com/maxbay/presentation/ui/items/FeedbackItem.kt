package com.maxbay.presentation.ui.items

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
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
import com.maxbay.presentation.ui.values.spaceBetweenFeedbackItems
import com.maxbay.presentation.ui.values.startItemHeight
import com.maxbay.presentation.ui.values.startItemWidth
import com.maxbay.productsTestEffectiveMobile.ui.ProductsTheme

@Composable
fun FeedbackItem(
    rating: Double,
    count: Int,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(spaceBetweenFeedbackItems),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            modifier = Modifier
                .height(startItemHeight)
                .width(startItemWidth),
            painter = painterResource(id = R.drawable.ic_star),
            contentDescription = stringResource(id = R.string.ic_star_description),
            tint = MaterialTheme.colorScheme.tertiary
        )

        Text(
            text = rating.toString(),
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.tertiary
        )

        Text(
            text = stringResource(id = R.string.feedback_count_str, count),
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.surface
        )
    }
}

@Composable
@Preview(showBackground = true)
internal fun FeedbackItemPreview() {
    ProductsTheme{
        FeedbackItem(
            rating = 4.5,
            count = 40
        )
    }
}