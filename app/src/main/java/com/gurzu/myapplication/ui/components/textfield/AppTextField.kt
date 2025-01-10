package com.gurzu.myapplication.ui.components.textfield

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text2.BasicTextField2
import androidx.compose.foundation.text2.input.CodepointTransformation
import androidx.compose.foundation.text2.input.TextFieldLineLimits
import androidx.compose.material3.LocalTextStyle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun AppTextField(
    modifier: Modifier = Modifier,
    state: AppTextFieldState,
    lineLimits: TextFieldLineLimits = TextFieldLineLimits.Default,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    textStyle: TextStyle = LocalTextStyle.current,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    codepointTransformation: CodepointTransformation? = null
) {
    BasicTextField2(
        modifier = modifier,
        value = state.text,
        onValueChange = { state.updateText(it) },
        lineLimits = lineLimits,
        keyboardOptions = keyboardOptions,
        textStyle = textStyle,
        keyboardActions = keyboardActions,
        codepointTransformation = codepointTransformation
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Preview
@Composable
fun AppTextFieldPreview() {
    val appTextFieldState = rememberAppTextFieldState("Value 1")
    AppTextField(state = appTextFieldState)
}
