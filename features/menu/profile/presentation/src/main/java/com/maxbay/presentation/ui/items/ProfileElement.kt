package com.maxbay.presentation.ui.items

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.maxbay.presentation.ui.values.cornerDefault
import com.maxbay.presentation.ui.values.paddingHorizontalProfileElement
import com.maxbay.presentation.ui.values.profileElementHeight
import com.maxbay.presentation.ui.values.profileLeftIconHeight
import com.maxbay.presentation.ui.values.profileLeftIconWidth
import com.maxbay.presentation.ui.values.space16
import com.maxbay.productsTestEffectiveMobile.ui.ProductsTheme

@Composable
fun ProfileElement(
    @DrawableRes
    leftIconId: Int,
    @StringRes
    contentDescriptionLeftIcon: Int,
    @DrawableRes
    rightIconId: Int,
    @StringRes
    contentDescriptionRightIcon: Int,
    title: String,
    subtitle: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(profileElementHeight)
            .background(
                shape = RoundedCornerShape(cornerDefault),
                color = MaterialTheme.colorScheme.onPrimary
            ),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = Modifier
                    .height(profileLeftIconHeight)
                    .width(profileLeftIconWidth)
                    .padding(start = paddingHorizontalProfileElement),
                painter = painterResource(id = leftIconId),
                contentDescription = stringResource(id = contentDescriptionLeftIcon),
                tint = Color.Unspecified
            )

            Spacer(modifier = Modifier.width(space16))

            Column(
                modifier = Modifier.fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleSmall,
                    color = MaterialTheme.colorScheme.onSurface
                )

                Text(
                    text = subtitle,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.surface
                )
            }
        }

        Icon(
            modifier = Modifier
                .wrapContentSize()
                .align(Alignment.CenterEnd)
                .padding(end = paddingHorizontalProfileElement),
            painter = painterResource(id = rightIconId),
            contentDescription = stringResource(id = contentDescriptionRightIcon),
            tint = Color.Unspecified
        )
    }
}

@Composable
@Preview(showBackground = true)
internal fun ProfileElementPreview() {
    ProductsTheme{
//        ProfileElement()
    }
}