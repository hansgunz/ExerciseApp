package com.example.excerciceapp.domain.usecase

import com.example.excerciceapp.domain.model.Exercise
import com.example.excerciceapp.domain.resource.DataError
import com.example.excerciceapp.domain.resource.Result
import kotlinx.coroutines.flow.Flow

interface FetchExercisesUseCase {

    suspend operator fun invoke(): Flow<Result<List<Exercise>, DataError.Network>>
}