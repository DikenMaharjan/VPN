package com.gurzu.myapplication.ui.components.textfield

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text2.BasicTextField2
import androidx.compose.foundation.text2.input.CodepointTransformation
import androidx.compose.foundation.text2.input.TextFieldLineLimits
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun AppTextField(
    modifier: Modifier = Modifier,
    state: AppTextFieldState,
    lineLimits: TextFieldLineLimits = TextFieldLineLimits.SingleLine,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    textStyle: TextStyle = MaterialTheme.typography.bodyLarge.copy(
        color = Color(0xFF333333)
    ),
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    codepointTransformation: CodepointTransformation? = null,
    endContent: (@Composable () -> Unit)? = null
) {
    BasicTextField2(
        modifier = modifier
            .background(MaterialTheme.colorScheme.background)
            .border(
                width = 1.dp,
                shape = RoundedCornerShape(12.dp),
                color = if (state.isError) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.primary
            )
            .padding(18.dp),
        value = state.text,
        onValueChange = { state.updateText(it) },
        lineLimits = lineLimits,
        keyboardOptions = keyboardOptions,
        textStyle = textStyle,
        keyboardActions = keyboardActions,
        codepointTransformation = codepointTransformation,
        decorator = { innerTextField ->
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.CenterStart
            ) {
                if (state.text.isBlank()) {
                    Text(state.hint, color = Color(0xFFABABB1))
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    innerTextField()
                    endContent?.invoke()
                }
            }
        }
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Preview
@Composable
fun AppTextFieldPreview() {
    val appTextFieldState = rememberAppTextFieldState("Value 1")
    AppTextField(state = appTextFieldState)
}
