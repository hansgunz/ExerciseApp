package com.example.excerciceapp.data.remote.model

import com.example.excerciceapp.domain.model.Exercise

data class ExerciseDTOItem(
    val difficulty: String,
    val equipment: String,
    val instructions: String,
    val muscle: String,
    val name: String,
    val type: String
){
    fun toExercise(): Exercise{
        return Exercise(
            difficulty = difficulty,
            equipment = equipment,
            instructions = instructions,
            muscle = muscle,
            name = name,
            type = type
        )
    }
}