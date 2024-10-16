package com.example.excerciceapp.presentation.viewmodels.states

import com.example.excerciceapp.domain.model.Exercise
import com.example.excerciceapp.presentation.viewmodels.utils.UiText

data class ExercisesByState(
    val exercisesList: List<Exercise> = emptyList(),
    val exercisesError: UiText = UiText.DynamicString(""),
    val exercisesIsLoading: Boolean = false
)