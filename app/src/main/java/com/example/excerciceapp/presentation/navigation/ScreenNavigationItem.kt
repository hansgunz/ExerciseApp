package com.example.excerciceapp.presentation.navigation

import com.example.excerciceapp.R
import com.example.excerciceapp.domain.model.Exercise
import com.example.excerciceapp.presentation.screen.ExerciseSearchItem
import com.example.excerciceapp.presentation.viewmodels.actions.ExercisesByAction
import kotlinx.serialization.Serializable

@Serializable
sealed class ScreenNavigationItem(
    val title: String,
    val icon: Int
) {
    @Serializable
    object ExercisesListNavigationItem: ScreenNavigationItem(
        title = "Home",
        icon = R.drawable.ic_exercise_home
    )

    @Serializable
    object ExerciseSearchNavigationItem: ScreenNavigationItem(
        title = "Search",
        icon = R.drawable.ic_exercise_search
    )

    @Serializable
    data class ExerciseDetailSNavigationItem(
        val exercise: Exercise
    ): ScreenNavigationItem(
        title = "Detail",
        icon = 0
    )

    @Serializable
    data class ExercisesByNavigationItem(
        val exercisesSearchItem: ExerciseSearchItem
    ): ScreenNavigationItem(
        title = "Exercises by",
        icon = 0
    )

    @Serializable
    data class ExerciseListByNavigationItem(
        val query: String,
        val action: ExercisesByAction
    ): ScreenNavigationItem(
        title = "Exercise list by",
        icon = 0
    )

}