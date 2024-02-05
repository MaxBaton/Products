package com.maxbay.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.maxbay.presentation.R
import com.maxbay.presentation.ui.items.FilterItem
import com.maxbay.presentation.ui.items.ProductItem
import com.maxbay.presentation.ui.items.SortItem
import com.maxbay.presentation.ui.items.Spacer16
import com.maxbay.presentation.ui.items.tag.TagItems
import com.maxbay.presentation.ui.values.paddingHorizontalBaseColumn
import com.maxbay.presentation.ui.values.spaceBetweenItems
import com.maxbay.presentation.viewModel.CatalogContract
import com.maxbay.productsTestEffectiveMobile.ui.ProductsTheme
import com.maxbay.productsTestEffectiveMobile.widgets.ProgressbarFullScreenItem
import com.maxbay.productsTestEffectiveMobile.widgets.TopBar
import kotlin.math.ceil
import kotlin.math.roundToInt

private const val GRID_ROW_ITEMS_COUNT = 2

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CatalogScreen(
    uiState: CatalogContract.State,
    onTagItemClick: (tag: String) -> Unit,
    onClearTagItemClick: () -> Unit,
    onFavoriteClick: (productId: String, isFavorite: Boolean) -> Unit,
    onSortClick: (sortCode: Int) -> Unit,
    onRepeatRequest: () -> Unit,
    modifier: Modifier = Modifier
) {
    when(uiState) {
        CatalogContract.State.Fail -> {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(id = R.string.fail_loading_message),
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onSurface
                )

                Button(
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.secondary
                    ),
                    onClick = onRepeatRequest
                ) {
                    Text(
                        text = stringResource(id = R.string.repeat_request),
                        style = MaterialTheme.typography.bodyLarge,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }
        }
        CatalogContract.State.Loading -> {
            ProgressbarFullScreenItem()
        }
        is CatalogContract.State.Success -> {
            LazyVerticalGrid(
                modifier = modifier
                    .fillMaxSize()
                    .padding(start = paddingHorizontalBaseColumn),
                columns = GridCells.Fixed(count = GRID_ROW_ITEMS_COUNT),
                verticalArrangement = Arrangement.spacedBy(spaceBetweenItems)
            ) {
                item(span = { GridItemSpan(currentLineSpan = GRID_ROW_ITEMS_COUNT) }) {
                    TopBar(title = stringResource(id = R.string.catalog_screen_title))
                }

                item(span = { GridItemSpan(currentLineSpan = GRID_ROW_ITEMS_COUNT) })  {
                    Row(
                        modifier = Modifier.padding(end = paddingHorizontalBaseColumn),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        SortItem(
                            sortOrders = uiState.sortOrders,
                            selectedSortIndex = uiState.selectedSortIndex,
                            onSortClick = onSortClick
                        )
                        FilterItem()
                    }
                }

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

@Composable
@Preview(showBackground = true)
internal fun CatalogScreenPreview() {
    ProductsTheme {
//        CatalogScreen(modifier = Modifier.background(color = MaterialTheme.colorScheme.primary))
    }
}