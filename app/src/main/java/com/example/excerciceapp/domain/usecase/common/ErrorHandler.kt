package com.example.excerciceapp.domain.usecase.common

import android.util.Log
import com.example.excerciceapp.domain.model.Exercise
import com.example.excerciceapp.domain.resource.DataError
import com.example.excerciceapp.domain.resource.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import javax.inject.Inject

class ErrorHandler @Inject constructor(){

    fun httpErrorHandling(e: HttpException, tag: String?): DataError.Network {
        return  when(e.code()){
            400 -> {
                Log.e(tag, "Error code: ${e.code()}")
                DataError.Network.BAD_REQUEST
            }
            408 -> {
                Log.e(tag, "Error code: ${e.code()}")
                DataError.Network.REQUEST_TIMEOUT
            }
            500 -> {
                Log.e(tag, "Error code: ${e.code()}")
                DataError.Network.SERVER_ERROR
            }
            else -> {
                Log.e(tag, "Error code: ${e.code()}")
                DataError.Network.UNKNOWN
            }
        }
    }

    fun iOErrorHandling(tag: String?): DataError.Network {
        Log.e(tag, "No internet connection")
        return DataError.Network.NO_INTERNET
    }
}