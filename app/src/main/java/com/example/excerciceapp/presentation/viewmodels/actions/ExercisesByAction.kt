package com.example.excerciceapp.presentation.viewmodels.actions

import kotlinx.serialization.Serializable

@Serializable
sealed interface ExercisesByAction {
    @Serializable
    data object ByType: ExercisesByAction
    @Serializable
    data object ByMuscle: ExercisesByAction
    @Serializable
    data object ByDifficulty: ExercisesByAction
    @Serializable
    data object ByName: ExercisesByAction
}