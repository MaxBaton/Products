package com.maxbay.productsTestEffectiveMobile.ui.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.maxbay.productsTestEffectiveMobile.ui.values.formTextFieldContentPaddings
import com.maxbay.productsTestEffectiveMobile.ui.values.formTextFieldCorner
import com.maxbay.productsTestEffectiveMobile.ui.values.formTextFieldHeight

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormTextField(
    modifier: Modifier = Modifier,
    value: String,
    enabled: Boolean = true,
    singleLine: Boolean = true,
    isError: Boolean = false,
    placeholder: String = "",
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    onChange: (value: String) -> Unit,
    keyboardOptions: KeyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
    visualTransformation: VisualTransformation = VisualTransformation.None,
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isFocused by interactionSource.collectIsFocusedAsState()

    BasicTextField(
        value = value,
        onValueChange = onChange,
        interactionSource = interactionSource,
        modifier = modifier.height(formTextFieldHeight),
        keyboardOptions = keyboardOptions,
        visualTransformation = visualTransformation,
        textStyle = TextStyle(
            color = if (isFocused) MaterialTheme.colorScheme.onBackground
            else MaterialTheme.colorScheme.onSurface
        ),
        decorationBox = { innerTextField ->
            TextFieldDefaults.OutlinedTextFieldDecorationBox(
                value = value,
                innerTextField = innerTextField,
                enabled = enabled,
                singleLine = singleLine,
                leadingIcon = leadingIcon,
                trailingIcon = if (value.isNotBlank()) trailingIcon else null,
                placeholder = {
                    Text(
                        modifier = Modifier.wrapContentSize(),
                        text = placeholder,
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.onSurface,
                        textAlign = TextAlign.Center
                    )
                },
                visualTransformation = visualTransformation,
                interactionSource = interactionSource,
                contentPadding = PaddingValues(all = formTextFieldContentPaddings),
                container = {
                    TextFieldDefaults.OutlinedBorderContainerBox(
                        enabled = enabled,
                        isError = isError,
                        interactionSource,
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            containerColor = MaterialTheme.colorScheme.onPrimary,
                            unfocusedBorderColor = MaterialTheme.colorScheme.onPrimary
                        ),
                        shape = RoundedCornerShape(formTextFieldCorner)
                    )
                }
            )
        }
    )
}


@Composable
@Preview(showBackground = true)
fun FormTextFieldPreview() {
    Box(
        modifier = Modifier.fillMaxWidth().background(color = MaterialTheme.colorScheme.background),
        contentAlignment = Alignment.Center
    ) {
        FormTextField(
            value = "",
            placeholder = "placeholder",
            onChange = {}
        )
    }
}