package com.gurzu.myapplication.ui.components.textfield

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.saveable.listSaver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.KeyboardType

open class AppTextFieldState(
    val initValue: String,
    val hint: String,
    val textType: TextType,
    val highlightError: Boolean,
    val transform: (String) -> String = { it }
) {
    var text by mutableStateOf(initValue)
        protected set

    var isError by mutableStateOf(false)
        protected set

    fun updateText(value: String) {
        text = transform(value)
        isError = false
    }


    val isValid: Boolean
        get() = textType.run {
            isError =false
            !isError
        }

    enum class TextType(val keyboardType: KeyboardType) {
        EMAIL(KeyboardType.Email),
        PASSWORD(KeyboardType.Password),
        TEXT(KeyboardType.Text)
    }

    companion object {
        val Saver: Saver<AppTextFieldState, *> = listSaver(
            save = { listOf(it.text, it.hint, it.textType.name, it.highlightError) },
            restore = {
                AppTextFieldState(
                    initValue = it[0] as String,
                    hint = it[1] as String,
                    textType = TextType.valueOf(it[2] as String),
                    highlightError = it[3] as Boolean
                )
            }
        )
    }
}

@Composable
fun rememberAppTextFieldState(
    hint: String,
    initValue: String = "",
    textType: AppTextFieldState.TextType = AppTextFieldState.TextType.TEXT,
    highlightError: Boolean = true,
    transform: (String) -> String = { it }
): AppTextFieldState =
    rememberSaveable(initValue, saver = AppTextFieldState.Saver) {
        AppTextFieldState(
            initValue = initValue,
            hint = hint,
            textType = textType,
            highlightError = highlightError,
            transform = transform
        )
    }


