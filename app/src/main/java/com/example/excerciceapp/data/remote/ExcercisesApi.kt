package com.example.excerciceapp.data.remote

import com.example.excerciceapp.data.remote.model.ExerciseDTO
import retrofit2.http.GET
import retrofit2.http.Query


interface ExercisesApi {

    @GET("exercises")
    suspend fun fetchExercises(): ExerciseDTO

    @GET("exercises")
    suspend fun fetchExercisesByMuscle(@Query("muscle") muscle: String): ExerciseDTO

    @GET("exercises")
    suspend fun fetchExercisesByName(@Query("name") name: String): ExerciseDTO

    @GET("exercises")
    suspend fun fetchExercisesByType(@Query("type") type: String): ExerciseDTO

    @GET("exercises")
    suspend fun fetchExercisesByDifficulty(@Query("difficulty") difficulty: String): ExerciseDTO
}