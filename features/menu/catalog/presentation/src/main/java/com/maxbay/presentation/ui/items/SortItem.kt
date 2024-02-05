package com.maxbay.presentation.ui.items

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import com.maxbay.presentation.R
import com.maxbay.presentation.models.SortOrderUi
import com.maxbay.presentation.ui.values.spaceSortIcon
import com.maxbay.presentation.ui.values.spaceSortText
import com.maxbay.productsTestEffectiveMobile.ui.ProductsTheme
import kotlinx.collections.immutable.ImmutableList

@Composable
fun SortItem(
    sortOrders: ImmutableList<SortOrderUi>,
    selectedSortIndex: Int,
    onSortClick: (sortCode: Int) -> Unit,
    modifier: Modifier = Modifier
) {
    var isContextMenuVisible by rememberSaveable {
        mutableStateOf(false)
    }
    var pressOffset by remember {
        mutableStateOf(DpOffset.Zero)
    }
    var itemHeight by remember {
        mutableStateOf(0.dp)
    }
    val density = LocalDensity.current

    Row(
        modifier = modifier
            .onSizeChanged {
                itemHeight = with(density) { it.height.toDp() }
            },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_sort),
            contentDescription = stringResource(id = R.string.ic_sort_description),
            tint = Color.Unspecified
        )

        Spacer(modifier = Modifier.width(spaceSortText))

        Text(
            text = stringResource(id = sortOrders[selectedSortIndex].titleId),
            style = MaterialTheme.typography.titleSmall,
            color = MaterialTheme.colorScheme.surfaceVariant
        )

        Spacer(modifier = Modifier.width(spaceSortIcon))

        Icon(
            modifier = Modifier
                .pointerInput(true) {
                    detectTapGestures(
                        onPress = {
                            isContextMenuVisible = true
                            pressOffset = DpOffset(it.x.toDp(), it.y.toDp())
                        }
                    )
                },
            painter = painterResource(id = R.drawable.ic_sort_popup),
            contentDescription = stringResource(id = R.string.ic_sort_popup_description),
            tint = Color.Unspecified
        )
    }

    DropdownMenu(
        modifier = Modifier.background(color = MaterialTheme.colorScheme.primary),
        expanded = isContextMenuVisible,
        onDismissRequest = { isContextMenuVisible = false }
    ) {
        sortOrders.forEach { sortOrder ->
            DropdownMenuItem(
                text = { 
                   Text(
                       text = stringResource(id = sortOrder.titleId),
                       style = MaterialTheme.typography.titleSmall,
                       color = MaterialTheme.colorScheme.surfaceVariant
                   )
                },
                onClick = {
                    onSortClick.invoke(sortOrder.sortCode)
                    isContextMenuVisible = false
                }
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
internal fun SortItemPreview() {
    ProductsTheme {
//        SortItem()
    }
}