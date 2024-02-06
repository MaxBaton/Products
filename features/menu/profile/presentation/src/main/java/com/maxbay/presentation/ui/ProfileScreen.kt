package com.maxbay.presentation.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.maxbay.presentation.R
import com.maxbay.presentation.ui.items.ButtonSignOutItem
import com.maxbay.presentation.ui.items.ProfileElement
import com.maxbay.presentation.ui.utils.getPhoneStr
import com.maxbay.presentation.ui.values.paddingBottomBtnSignOut
import com.maxbay.presentation.ui.values.paddingHorizontalBaseColumn
import com.maxbay.presentation.ui.values.space24
import com.maxbay.presentation.ui.values.spaceBetweenProfileElements
import com.maxbay.presentation.viewModel.ProfileContract
import com.maxbay.productsTestEffectiveMobile.ui.ProductsTheme
import com.maxbay.productsTestEffectiveMobile.widgets.TopBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(
    uiState: ProfileContract.State,
    onSignOutClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    when(uiState) {
        ProfileContract.State.Fail -> {}
        ProfileContract.State.Loading -> {}
        is ProfileContract.State.Success -> {
            Box(
                modifier = modifier
                    .fillMaxSize()
                    .padding(horizontal = paddingHorizontalBaseColumn)
            ) {

                Column(
                    verticalArrangement = Arrangement.spacedBy(spaceBetweenProfileElements)
                ) {
                    TopBar(title = stringResource(id = R.string.profile_screen_top_bar_title))

                    ProfileElement(
                        leftIconId = R.drawable.ic_profile,
                        contentDescriptionLeftIcon = R.string.ic_profile_description,
                        rightIconId = R.drawable.ic_sign_out,
                        contentDescriptionRightIcon = R.string.ic_sign_out_description,
                        title = "${uiState.user.firstName} ${uiState.user.secondName}",
                        subtitle = uiState.user.mobilePhone.getPhoneStr()
                    )
                    
                    Spacer(modifier = Modifier.height(space24))

                    ProfileElement(
                        leftIconId = R.drawable.ic_favorite,
                        contentDescriptionLeftIcon = R.string.ic_favorite_description,
                        rightIconId = R.drawable.ic_next,
                        contentDescriptionRightIcon = R.string.ic_next_description,
                        title = stringResource(id = R.string.favorite),
                        subtitle = stringResource(id = R.string.favorites_count, uiState.favoritesCount)
                    )
                }

                ButtonSignOutItem(
                    modifier = Modifier.align(Alignment.BottomCenter),
                    onSignOutClick = onSignOutClick
                )
                
                Spacer(modifier = Modifier.height(paddingBottomBtnSignOut))
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
internal fun ProfileScreenPreview() {
    ProductsTheme {
//        ProfileScreen(
//            uiState = ProfileContract.State.Success(
//                user = User()
//            )
//        )
    }
}