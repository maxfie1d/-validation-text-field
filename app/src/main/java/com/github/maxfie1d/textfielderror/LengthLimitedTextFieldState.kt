package com.github.maxfie1d.textfielderror

import androidx.compose.runtime.Stable
import androidx.compose.runtime.mutableStateOf

@Stable
class LengthLimitedTextFieldState(
    error: Boolean,
) {
    private val errorState = mutableStateOf(error)
    val error get() = errorState.value

    fun update(error: Boolean) {
        if (errorState.value != error) {
            errorState.value = error
        }
    }
}
