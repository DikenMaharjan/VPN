package com.gurzu.myapplication.login.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color


@Composable
fun ForgotPasswordRow(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.fillMaxWidth(),
    ) {
        Text(
            modifier = Modifier.align(Alignment.Center),
            text = "忘记密码?",
            color = Color(0xFFA1A1AC)
        )
        Text(
            modifier = Modifier.align(Alignment.CenterEnd),
            text = "通过邮箱找回",
            color = Color(0xFFFFA210)
        )
    }
}

