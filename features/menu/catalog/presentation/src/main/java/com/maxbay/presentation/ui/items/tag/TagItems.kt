package com.maxbay.presentation.ui.items.tag

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.maxbay.presentation.models.TagUi
import com.maxbay.presentation.ui.values.paddingHorizontalBaseColumn
import com.maxbay.presentation.ui.values.spaceBetweenTagItems
import com.maxbay.productsTestEffectiveMobile.ui.ProductsTheme
import kotlinx.collections.immutable.ImmutableList

@Composable
fun TagItems(
    tags: ImmutableList<TagUi>,
    selectedIndex: Int,
    onTagItemClick: (tag: String) -> Unit,
    onClearTagItemClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(spaceBetweenTagItems)
    ) {
        itemsIndexed(tags) { index, tag ->
            TagItem(
                tag = tag,
                isSelected = index == selectedIndex,
                onItemClick = onTagItemClick,
                onClearItemClick = onClearTagItemClick
            )

            if (index == tags.size - 1) {
                Spacer(modifier = Modifier.width(paddingHorizontalBaseColumn))
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
internal fun TagItemsPreview() {
    ProductsTheme{
//        TagItems()
    }
}