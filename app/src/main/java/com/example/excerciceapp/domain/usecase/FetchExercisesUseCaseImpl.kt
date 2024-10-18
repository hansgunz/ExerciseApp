package com.example.excerciceapp.domain.usecase

import android.util.Log
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

class FetchExercisesUseCaseImpl @Inject constructor(
    private val remoteRepository: RemoteRepository,
    private val errorHandler: ErrorHandler
) : FetchExercisesUseCase{
    private val TAG = this::class.simpleName

    override suspend fun invoke(): Flow<Result<List<Exercise>, DataError.Network>> = flow {
        try{
            emit(Result.Loading())
            val exercises = remoteRepository.fetchExercises().map { it.toExercise() }
            emit(Result.Success(exercises))
        } catch (e: HttpException){
            emit(Result.Error(errorHandler.httpErrorHandling(e, TAG)))
        } catch (e: IOException){
            emit(Result.Error(errorHandler.iOErrorHandling(TAG)))
        }
    }
}