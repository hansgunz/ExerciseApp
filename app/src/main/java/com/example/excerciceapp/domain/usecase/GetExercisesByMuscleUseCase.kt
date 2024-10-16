package com.example.excerciceapp.domain.usecase

import com.example.excerciceapp.domain.model.Exercise
import com.example.excerciceapp.domain.resource.DataError
import com.example.excerciceapp.domain.resource.Error
import com.example.excerciceapp.domain.resource.Result
import kotlinx.coroutines.flow.Flow

interface GetExercisesByMuscleUseCase {

    suspend operator fun invoke(muscle: String): Flow<Result<List<Exercise>, DataError.Network>>
}