package com.maxbay.productsTestEffectiveMobile.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.maxbay.productsTestEffectiveMobile.presentation.R
import com.maxbay.productsTestEffectiveMobile.ui.ProductsTheme
import com.maxbay.productsTestEffectiveMobile.ui.tools.PhoneVisualTransformation
import com.maxbay.productsTestEffectiveMobile.ui.values.buttonHeight
import com.maxbay.productsTestEffectiveMobile.ui.values.formTextFieldPaddingHorizontal
import com.maxbay.productsTestEffectiveMobile.ui.values.formTextFieldSpaceBetween
import com.maxbay.productsTestEffectiveMobile.ui.widgets.FormTextField
import com.maxbay.productsTestEffectiveMobile.ui.widgets.IconDeleteText
import com.maxbay.productsTestEffectiveMobile.ui.widgets.RoundButton
import com.maxbay.productsTestEffectiveMobile.viewModel.AuthContract
import com.maxbay.productsTestEffectiveMobile.widgets.TopBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AuthScreen(
    uiState: AuthContract.State,
    onFirstNameChange: (firstName: String) -> Unit,
    onSecondNameChange: (secondName: String) -> Unit,
    onMobilePhoneChange: (mobilePhone: String) -> Unit,
    onClearFirstName: () -> Unit,
    onClearSecondName: () -> Unit,
    onClearMobilePhone: () -> Unit,
    onSignUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.primary)
    ) {
        TopBar(title = stringResource(id = R.string.auth_title))
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = formTextFieldPaddingHorizontal),
                verticalArrangement = Arrangement.spacedBy(formTextFieldSpaceBetween)
            ) {
                FormTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = uiState.firstName,
                    placeholder = stringResource(id = R.string.first_name_placeholder),
                    isError = uiState.firstNameError,
                    trailingIcon = {
                        IconDeleteText(onClick = onClearFirstName)
                    },
                    keyboardOptions = KeyboardOptions(
                        imeAction = ImeAction.Next
                    ),
                    onChange = onFirstNameChange
                )

                FormTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = uiState.secondName,
                    placeholder = stringResource(id = R.string.second_name_placeholder),
                    isError = uiState.secondNameError,
                    trailingIcon = {
                        IconDeleteText(onClick = onClearSecondName)
                    },
                    keyboardOptions = KeyboardOptions(
                        imeAction = ImeAction.Next
                    ),
                    onChange = onSecondNameChange
                )

                FormTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = uiState.mobilePhone,
                    placeholder = stringResource(id = R.string.mobile_phone_placeholder),
                    isError = uiState.mobilePhoneError,
                    trailingIcon = {
                        IconDeleteText(onClick = onClearMobilePhone)
                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Decimal,
                        imeAction = ImeAction.Done
                    ),
                    visualTransformation = PhoneVisualTransformation(
                        mask = PhoneVisualTransformation.RU_MASK,
                        maskCharacter = PhoneVisualTransformation.RU_CHAR
                    ),
                    onChange = onMobilePhoneChange
                )

                Spacer(modifier = Modifier.height(16.dp))

                RoundButton(
                    modifier = Modifier.height(buttonHeight),
                    isEnable = uiState.isCorrectInput,
                    onClick = onSignUp
                )
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
internal fun AuthScreenPreview() {
    ProductsTheme {
//        AuthScreen(
//            onNavigateToMenu = {}
//        )
    }
}