package com.example.excerciceapp.presentation.screen.utils

import androidx.compose.ui.text.capitalize
import com.example.excerciceapp.presentation.screen.items.ExerciseGroup

fun String.exerciseGroupFormat(): String{
    return this.replaceFirstChar { it.uppercase() }.replace( "_", " ")
}