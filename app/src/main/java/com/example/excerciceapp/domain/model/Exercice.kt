package com.example.excerciceapp.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Exercise(
    val difficulty: String,
    val equipment: String,
    val instructions: String,
    val muscle: String,
    val name: String,
    val type: String
)
