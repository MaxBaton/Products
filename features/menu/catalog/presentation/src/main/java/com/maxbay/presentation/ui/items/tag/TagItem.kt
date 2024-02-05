package com.maxbay.presentation.ui.items.tag

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.maxbay.presentation.models.TAG_ALL
import com.maxbay.presentation.models.TagUi
import com.maxbay.presentation.ui.values.cornerTagItem
import com.maxbay.presentation.ui.values.paddingHorizontalTagItem
import com.maxbay.presentation.ui.values.paddingStartIconClear
import com.maxbay.presentation.ui.values.paddingVerticalTagItem
import com.maxbay.productsTestEffectiveMobile.ui.ProductsTheme

@Composable
fun TagItem(
    tag: TagUi,
    isSelected: Boolean,
    onItemClick: (tag: String) -> Unit,
    onClearItemClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .background(
                shape = RoundedCornerShape(size = cornerTagItem),
                color = if (isSelected) {
                    MaterialTheme.colorScheme.onSurfaceVariant
                } else {
                    MaterialTheme.colorScheme.onPrimary
                }
            )
            .padding(
                start = paddingHorizontalTagItem,
                end = paddingHorizontalTagItem,
                top = paddingVerticalTagItem,
                bottom = paddingVerticalTagItem
            )
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = modifier.clickable {
                    onItemClick.invoke(tag.tagServer)
                },
                text = stringResource(id = tag.tagUiId),
                style = MaterialTheme.typography.titleSmall,
                color = if (isSelected) {
                    MaterialTheme.colorScheme.primary
                }else {
                    MaterialTheme.colorScheme.surface
                }
            )

            if (isSelected) {
                Icon(
                    modifier = Modifier
                        .padding(start = paddingStartIconClear)
                        .clickable{
                            onClearItemClick.invoke()
                        },
                    painter = painterResource(id = R.drawable.ic_clear_tag),
                    contentDescription = stringResource(id = R.string.ic_clear_tag_description),
                    tint = MaterialTheme.colorScheme.primary
                )
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
internal fun TagItemPreview() {
    ProductsTheme{
        TagItem(
            tag = TagUi(tagServer = TAG_ALL, tagUiId = R.string.tag_all),
            isSelected = true,
            onItemClick = {},
            onClearItemClick = {}
        )
    }
}