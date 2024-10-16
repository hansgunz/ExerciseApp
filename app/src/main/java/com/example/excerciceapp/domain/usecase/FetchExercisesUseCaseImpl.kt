package com.example.excerciceapp.domain.usecase

import android.util.Log
import com.example.excerciceapp.domain.model.Exercise
import com.example.excerciceapp.domain.repository.RemoteRepository
import com.example.excerciceapp.domain.resource.DataError
import com.example.excerciceapp.domain.resource.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class FetchExercisesUseCaseImpl @Inject constructor(private val remoteRepository: RemoteRepository)
    : FetchExercisesUseCase{
        private val TAG = this::class.simpleName

    override suspend fun invoke(): Flow<Result<List<Exercise>, DataError.Network>> = flow {
        try{
            emit(Result.Loading())
            val exercises = remoteRepository.fetchExercises().map { it.toExercise() }
            emit(Result.Success(exercises))
        } catch (e: HttpException){
            when(e.code()){
                400 -> {
                    Log.e(TAG, "Error code: ${e.code()}")
                    emit(Result.Error(DataError.Network.BAD_REQUEST))
                }
                408 -> {
                    Log.e(TAG, "Error code: ${e.code()}")
                    emit(Result.Error(DataError.Network.REQUEST_TIMEOUT))
                }
                500 -> {
                    Log.e(TAG, "Error code: ${e.code()}")
                    emit(Result.Error(DataError.Network.SERVER_ERROR))
                }
                else -> {
                    Log.e(TAG, "Error code: ${e.code()}")
                    emit(Result.Error(DataError.Network.UNKNOWN))
                }
            }
        } catch (e: IOException){
            Log.e(TAG, "No internet connection")
            emit(Result.Error(DataError.Network.NO_INTERNET))
        }
    }
}