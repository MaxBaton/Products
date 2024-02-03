package com.maxbay.presentation.ui.items.tag

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.maxbay.productsTestEffectiveMobile.ui.ProductsTheme
import com.maxbay.productsTestEffectiveMobile.ui.zeroVal
import kotlinx.collections.immutable.ImmutableList

@Composable
fun TagItems(
    tags: ImmutableList<String>,
    selectedIndex: Int,
    onTagItemClick: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        itemsIndexed(tags) { index, tag ->
            val padding = if (index == tags.size - 1) {
                16.dp
            }else {
                zeroVal
            }

            TagItem(
                modifier = Modifier.padding(end = padding),
                tag = tag,
                isSelected = index == selectedIndex,
                onItemClick = onTagItemClick
            )
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