package com.example.excerciceapp.presentation.screen.common

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.excerciceapp.presentation.viewmodels.utils.UiText

@Composable
fun ErrorText(
    text: UiText
){
    Text(
        text = text.asString(),
        style = MaterialTheme.typography.headlineMedium,
        color = MaterialTheme.colorScheme.error
    )
}