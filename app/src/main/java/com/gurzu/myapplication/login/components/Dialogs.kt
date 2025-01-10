package com.gurzu.myapplication.login.components

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable

@Composable
fun Dialog(
    msg: String, onDismiss: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
        },
        text = {
            Text(text = msg)
        },
        confirmButton = {

        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("Ok")
            }
        }
    )
}