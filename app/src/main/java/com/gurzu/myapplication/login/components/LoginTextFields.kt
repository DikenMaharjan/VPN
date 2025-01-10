package com.gurzu.myapplication.login.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun LoginTextFields(modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxWidth()) {
        OutlinedTextField(
            value = "", onValueChange = {})
        Spacer(modifier = Modifier.height(24.dp))
        OutlinedTextField(value = "", onValueChange = {})
    }
}