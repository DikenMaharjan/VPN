package com.gurzu.myapplication.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.gurzu.myapplication.R
import com.gurzu.myapplication.login.components.ForgotPasswordRow
import com.gurzu.myapplication.login.components.LoginTextFields
import com.gurzu.myapplication.login.components.ScanQrButton

@Composable
fun LoginScreen(modifier: Modifier = Modifier) {
    LoginScreenContent(
        modifier = modifier,
        onScanQr = {},
        onSignIn = {}
    )
}

@Composable
private fun LoginScreenContent(
    modifier: Modifier = Modifier,
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
                .padding(24.dp),
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ScanQrButton(modifier = Modifier.align(Alignment.End), onClick = onScanQr)
            Text("立即登录以访问更快的互联网\n超过120+个位置。")
            LoginTextFields()
            ForgotPasswordRow()
            SignInButton(
                onSignIn = onSignIn
            )
            Spacer(modifier = Modifier)
        }
    }
}


@Composable
fun SignInButton(modifier: Modifier = Modifier, onSignIn: () -> Unit) {
    Button(
        modifier = modifier.fillMaxWidth(),
        onClick = onSignIn
    ) {
        Text("登录")
    }
}