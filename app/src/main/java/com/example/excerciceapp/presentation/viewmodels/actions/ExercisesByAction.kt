package com.example.excerciceapp.presentation.viewmodels.actions

import kotlinx.serialization.Serializable

@Serializable
enum class ExercisesByAction {
    BY_TYPE,
    BY_MUSCLE,
    BY_DIFFICULTY,
    BY_NAME
}