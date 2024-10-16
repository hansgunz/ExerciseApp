package com.example.excerciceapp.data.repository

import com.example.excerciceapp.data.remote.ExercisesApi
import com.example.excerciceapp.data.remote.model.ExerciseDTO
import com.example.excerciceapp.domain.repository.RemoteRepository
import javax.inject.Inject

class RemoteRepositoryImpl @Inject constructor(private val api: ExercisesApi): RemoteRepository {
    override suspend fun fetchExercises(): ExerciseDTO {
        return api.fetchExercises()
    }

    override suspend fun fetchExercisesByMuscle(muscle: String): ExerciseDTO {
        return api.fetchExercisesByMuscle(muscle)
    }

    override suspend fun fetchExercisesByType(type: String): ExerciseDTO {
        return api.fetchExercisesByType(type)
    }

    override suspend fun fetchExercisesByDifficulty(difficulty: String): ExerciseDTO {
        return api.fetchExercisesByDifficulty(difficulty)
    }

    override suspend fun fetchExercisesByName(name: String): ExerciseDTO {
        return api.fetchExercisesByName(name)
    }
}