package com.gurzu.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.view.WindowCompat
import com.gurzu.myapplication.login.LoginScreen
import com.gurzu.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            MyApplicationTheme(
                darkTheme = false,
                dynamicColor = false
            ) {
                LoginScreen()
            }
        }
    }
}