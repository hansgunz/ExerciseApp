package com.example.excerciceapp.domain.usecase

import com.example.excerciceapp.domain.model.Exercise
import com.example.excerciceapp.domain.repository.RemoteRepository
import com.example.excerciceapp.domain.resource.DataError
import com.example.excerciceapp.domain.resource.Result
import com.example.excerciceapp.domain.usecase.common.ErrorHandler
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetExercisesByMuscleUseCaseImpl @Inject constructor(
    private val remoteRepository: RemoteRepository,
    private val errorHandler: ErrorHandler
): GetExercisesByMuscleUseCase {
    private val TAG = this::class.simpleName

    override suspend fun invoke(muscle: String): Flow<Result<List<Exercise>, DataError.Network>> = flow {
        try {
            emit(Result.Loading())
            val exercisesByMuscle = remoteRepository
                .fetchExercisesByMuscle(muscle)
                .map { it.toExercise() }
            emit(Result.Success(exercisesByMuscle))
        } catch (e: HttpException){
            emit(Result.Error(errorHandler.httpErrorHandling(e, TAG)))
        } catch (e: IOException){
            emit(Result.Error(errorHandler.iOErrorHandling(tag = TAG)))
        }
    }
}