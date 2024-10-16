package com.example.excerciceapp.di

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AuthInterceptor @Inject constructor(): Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val newRequest =
            originalRequest.newBuilder().header("X-Api-Key", API_KEY).build()

        return chain.proceed(newRequest)
    }

    companion object{
        private const val API_KEY = "T5kMvYxgXpD4ppl3op0cZQpnPbbPvWNXshWebRzd"
    }
}