package com.gurzu.myapplication.login.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text2.input.CodepointTransformation
import androidx.compose.foundation.text2.input.mask
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.gurzu.myapplication.R
import com.gurzu.myapplication.ui.components.textfield.AppTextField
import com.gurzu.myapplication.ui.components.textfield.AppTextFieldState

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LoginForm(
    modifier: Modifier = Modifier,
    emailState: AppTextFieldState,
    passwordState: AppTextFieldState,
    onSignIn: () -> Unit
) {
    var isPasswordVisible by rememberSaveable { mutableStateOf(false) }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        val focusManager = LocalFocusManager.current
        AppTextField(
            modifier = Modifier.fillMaxWidth(),
            state = emailState,
            keyboardActions = KeyboardActions(
                onNext = {
                    focusManager.moveFocus(FocusDirection.Down)
                }
            ),
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next
            )
        )
        AppTextField(
            modifier = Modifier.fillMaxWidth(),
            state = passwordState,
            codepointTransformation = if (isPasswordVisible) {
                null
            } else {
                CodepointTransformation.mask('*')
            },
            endContent = {
                Icon(
                    modifier = Modifier.clickable {
                        isPasswordVisible = !isPasswordVisible
                    },
                    painter = painterResource(if (isPasswordVisible) R.drawable.hide_password else R.drawable.show_password),
                    contentDescription = null
                )
            },
            keyboardActions = KeyboardActions(
                onDone = {
                    onSignIn()
                }
            )
        )
        ForgotPasswordRow()
        Spacer(modifier = Modifier.height(24.dp))
        SignInButton(onSignIn = onSignIn)
    }
}

@Composable
fun SignInButton(modifier: Modifier = Modifier, onSignIn: () -> Unit) {
    Button(
        modifier = modifier.fillMaxWidth(), onClick = onSignIn
    ) {
        Text("登录")
    }
}