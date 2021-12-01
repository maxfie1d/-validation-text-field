package com.github.maxfie1d.textfielderror

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.github.maxfie1d.textfielderror.ui.theme.TextfielderrorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TextfielderrorTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val state = rememberMyTextFieldState()
                    val (value, onValueChange) = remember {
                        mutableStateOf("")
                    }

                    Column {
                        LengthLimitedTextField(
                            state = state,
                            maxLength = 10,
                            value = value,
                            onValueChange = onValueChange,
                        )

                        if (state.error) {
                            Text(text = "最大文字数を超えています")
                        }
                    }
                }
            }
        }
    }
}
