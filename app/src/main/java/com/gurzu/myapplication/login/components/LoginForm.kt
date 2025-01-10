package com.gurzu.myapplication.login.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text2.input.CodepointTransformation
import androidx.compose.foundation.text2.input.mask
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.gurzu.myapplication.R
import com.gurzu.myapplication.ui.components.textfield.AppTextField
import com.gurzu.myapplication.ui.components.textfield.AppTextFieldState

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LoginForm(
    modifier: Modifier = Modifier,
    emailState: AppTextFieldState,
    passwordState: AppTextFieldState
) {
    var isPasswordVisible by rememberSaveable { mutableStateOf(false) }

    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        AppTextField(
            modifier = Modifier.fillMaxWidth(),
            state = emailState
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
            }
        )
        ForgotPasswordRow()
    }
}