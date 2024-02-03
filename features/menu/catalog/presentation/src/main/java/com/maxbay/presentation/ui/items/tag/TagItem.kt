package com.maxbay.presentation.ui.items.tag

import androidx.compose.foundation.clickable
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.maxbay.productsTestEffectiveMobile.ui.ProductsTheme

@Composable
fun TagItem(
    tag: String,
    isSelected: Boolean,
    onItemClick: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Text(
        modifier = modifier.clickable {
            onItemClick.invoke(tag)
        },
        text = tag,
        style = MaterialTheme.typography.titleLarge,
        color = if (isSelected) {
            MaterialTheme.colorScheme.secondary
        }else {
            MaterialTheme.colorScheme.tertiary
        }
    )
}

@Composable
@Preview(showBackground = true)
internal fun TagItemPreview() {
    ProductsTheme{
        TagItem(
            tag = "tag",
            isSelected = false,
            onItemClick = {}
        )
    }
}