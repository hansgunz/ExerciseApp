package com.example.excerciceapp.domain.repository

import com.example.excerciceapp.data.remote.model.ExerciseDTO

interface RemoteRepository {

    suspend fun fetchExercises(): ExerciseDTO

    suspend fun fetchExercisesByMuscle(muscle: String): ExerciseDTO

    suspend fun fetchExercisesByType(type: String): ExerciseDTO

    suspend fun fetchExercisesByDifficulty(difficulty: String): ExerciseDTO

    suspend fun fetchExercisesByName(name: String): ExerciseDTO
}