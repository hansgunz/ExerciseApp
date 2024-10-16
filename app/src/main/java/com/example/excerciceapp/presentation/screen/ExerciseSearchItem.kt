package com.example.excerciceapp.presentation.screen

import kotlinx.serialization.Serializable

@Serializable
sealed class ExerciseSearchItem(val text: String, val queryParam: String) {
    @Serializable
    data object ExerciseByName: ExerciseSearchItem(text = "By Name", queryParam = "name")

    @Serializable
    data object ExerciseByType: ExerciseSearchItem(text = "By Type", queryParam = "type")

    @Serializable
    data object ExerciseByMuscle: ExerciseSearchItem(text = "By Muscle", queryParam = "muscle")

    @Serializable
    data object ExerciseByDifficulty: ExerciseSearchItem(text = "By Difficulty", queryParam = "difficulty")
}