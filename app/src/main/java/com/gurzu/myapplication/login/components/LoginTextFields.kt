package com.gurzu.myapplication.login.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.gurzu.myapplication.ui.components.textfield.AppTextField
import com.gurzu.myapplication.ui.components.textfield.AppTextFieldState

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LoginTextFields(
    modifier: Modifier = Modifier,
    emailState: AppTextFieldState,
    passwordState: AppTextFieldState
) {
    Column(modifier = modifier.fillMaxWidth()) {
        AppTextField(
            modifier = Modifier.fillMaxWidth(),
            state = emailState
        )
        Spacer(modifier = Modifier.height(24.dp))
        AppTextField(
            modifier = Modifier.fillMaxWidth(),
            state = passwordState
        )
    }
}