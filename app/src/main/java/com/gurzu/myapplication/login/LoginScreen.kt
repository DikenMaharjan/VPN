package com.gurzu.myapplication.login

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.gurzu.myapplication.R
import com.gurzu.myapplication.login.components.LoginForm
import com.gurzu.myapplication.login.components.ScanQrButton
import com.gurzu.myapplication.ui.components.textfield.AppTextFieldState
import com.gurzu.myapplication.ui.components.textfield.AppTextFieldState.TextType
import com.gurzu.myapplication.ui.components.textfield.rememberAppTextFieldState

@Composable
fun LoginScreen(modifier: Modifier = Modifier) {
    val emailState = rememberAppTextFieldState(hint = "请输入ID/邮箱", textType = TextType.EMAIL)
    val passwordState = rememberAppTextFieldState(hint = "请输入密码", textType = TextType.PASSWORD)
    val context = LocalContext.current
    LoginScreenContent(
        modifier = modifier,
        emailState = emailState,
        passwordState = passwordState,
        onScanQr = {},
        onSignIn = {
            val isValid = listOf(emailState.isValid, passwordState.isValid).all { it }
            if (isValid) {
                context.showShortToast("Success")
            } else {
                context.showShortToast("Invalid Data")
            }
        }
    )
}

@Composable
private fun LoginScreenContent(
    modifier: Modifier = Modifier,
    emailState: AppTextFieldState,
    passwordState: AppTextFieldState,
    onScanQr: () -> Unit,
    onSignIn: () -> Unit
) {
    Box(modifier = modifier) {
        Image(
            modifier = Modifier.fillMaxWidth(),
            painter = painterResource(R.drawable.login_background),
            contentDescription = "Login Background",
            contentScale = ContentScale.FillWidth
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .systemBarsPadding()
                .imePadding()
                .padding(24.dp),
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ScanQrButton(modifier = Modifier.align(Alignment.End), onClick = onScanQr)
            Text(
                modifier = Modifier.align(Alignment.Start),
                text = "立即登录以访问更快的互联网\n超过120+个位置。",
                style = MaterialTheme.typography.bodySmall,
                color = Color(0xFF666666)
            )
            LoginForm(
                emailState = emailState, passwordState = passwordState
            )
            SignInButton(
                onSignIn = onSignIn
            )
            Spacer(modifier = Modifier)
        }
    }
}

private fun Context.showShortToast(msg: String) {
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
}

@Composable
fun SignInButton(modifier: Modifier = Modifier, onSignIn: () -> Unit) {
    Button(
        modifier = modifier.fillMaxWidth(), onClick = onSignIn
    ) {
        Text("登录")
    }
}