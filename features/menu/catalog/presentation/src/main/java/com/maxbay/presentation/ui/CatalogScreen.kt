package com.maxbay.presentation.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.maxbay.presentation.ui.items.ProductItem
import com.maxbay.presentation.ui.items.Spacer16
import com.maxbay.presentation.ui.items.tag.TagItem
import com.maxbay.presentation.ui.items.tag.TagItems
import com.maxbay.presentation.ui.values.paddingHorizontalBaseColumn
import com.maxbay.presentation.ui.values.spaceBetweenItems
import com.maxbay.presentation.viewModel.CatalogContract
import com.maxbay.productsTestEffectiveMobile.ui.ProductsTheme
import kotlin.math.ceil
import kotlin.math.roundToInt

private const val GRID_ROW_ITEMS_COUNT = 2

@Composable
fun CatalogScreen(
    uiState: CatalogContract.State,
    onTagItemClick: (tag: String) -> Unit,
    onClearTagItemClick: () -> Unit,
    onFavoriteClick: (productId: String, isFavorite: Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        when(uiState) {
            CatalogContract.State.Fail -> Text(text = "fail")
            CatalogContract.State.Loading -> Text(text = "loading")
            is CatalogContract.State.Success -> {
                LazyVerticalGrid(
                    modifier = modifier
                        .fillMaxSize()
                        .padding(start = paddingHorizontalBaseColumn),
                    columns = GridCells.Fixed(count = GRID_ROW_ITEMS_COUNT),
                    verticalArrangement = Arrangement.spacedBy(spaceBetweenItems)
                ) {
                    item(span = { GridItemSpan(currentLineSpan = GRID_ROW_ITEMS_COUNT) }) {
                        // Tags
                        TagItems(
                            modifier = Modifier.fillMaxWidth(),
                            tags = uiState.tags,
                            selectedIndex = uiState.selectedTagIndex,
                            onTagItemClick = onTagItemClick,
                            onClearTagItemClick = onClearTagItemClick
                        )
                    }

                    val rowCount = ceil(uiState.products.size.toFloat() / GRID_ROW_ITEMS_COUNT).roundToInt()
                    itemsIndexed(uiState.products) { index, product ->
                        Column {
                            ProductItem(
                                modifier = Modifier
                                    .aspectRatio(1f)
                                    .fillMaxWidth()
                                    .padding(end = 16.dp),
                                product = product,
                                onFavoriteClick = onFavoriteClick
                            )

                            // Check if the latest row
                            if (index >= (rowCount - 1) * GRID_ROW_ITEMS_COUNT) {
                                Spacer16()
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
internal fun CatalogScreenPreview() {
    ProductsTheme {
//        CatalogScreen(modifier = Modifier.background(color = MaterialTheme.colorScheme.primary))
    }
}