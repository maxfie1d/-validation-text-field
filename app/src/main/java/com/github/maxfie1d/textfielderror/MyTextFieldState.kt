package com.github.maxfie1d.textfielderror

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier

@Composable
fun LengthLimitedTextField(
    state: LengthLimitedTextFieldState = rememberMyTextFieldState(),
    maxLength: Int,
    value: String,
    onValueChange: (String) -> Unit,
) {
    OutlinedTextField(
        value = value,
        onValueChange = {
            val isError = it.length > maxLength
            state.update(isError)

            onValueChange(it)
        },
        modifier = Modifier.fillMaxWidth(),
    )
}

@Composable
fun rememberMyTextFieldState(): LengthLimitedTextFieldState {
    return remember {
        LengthLimitedTextFieldState(error = false)
    }
}
