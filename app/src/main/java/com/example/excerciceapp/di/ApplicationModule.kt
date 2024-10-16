package com.example.excerciceapp.di

import com.example.excerciceapp.data.remote.ExercisesApi
import com.example.excerciceapp.data.repository.RemoteRepositoryImpl
import com.example.excerciceapp.di.Const.BASE_URL
import com.example.excerciceapp.domain.repository.RemoteRepository
import com.example.excerciceapp.domain.usecase.FetchExercisesUseCase
import com.example.excerciceapp.domain.usecase.FetchExercisesUseCaseImpl
import com.example.excerciceapp.domain.usecase.GetExercisesByDifficultyUseCase
import com.example.excerciceapp.domain.usecase.GetExercisesByDifficultyUseCaseImpl
import com.example.excerciceapp.domain.usecase.GetExercisesByMuscleUseCase
import com.example.excerciceapp.domain.usecase.GetExercisesByMuscleUseCaseImpl
import com.example.excerciceapp.domain.usecase.GetExercisesByNameUseCase
import com.example.excerciceapp.domain.usecase.GetExercisesByNameUseCaseImpl
import com.example.excerciceapp.domain.usecase.GetExercisesByTypeUseCase
import com.example.excerciceapp.domain.usecase.GetExercisesByTypeUseCaseImpl
import com.example.excerciceapp.domain.usecase.common.ErrorHandler
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApplicationModule {

    @Provides
    @Singleton
    fun provideLoggingInterceptor(): HttpLoggingInterceptor{
        return HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(authInterceptor: AuthInterceptor, loggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(authInterceptor)
            .addInterceptor(loggingInterceptor)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit{
        return Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideExerciseApi(retrofit: Retrofit): ExercisesApi{
        return retrofit.create(ExercisesApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRemoteRepository(exercisesApi: ExercisesApi): RemoteRepository{
        return RemoteRepositoryImpl(exercisesApi)
    }

    @Provides
    @Singleton
    fun provideFetchExercisesUseCase(remoteRepository: RemoteRepository): FetchExercisesUseCase{
        return FetchExercisesUseCaseImpl(remoteRepository)
    }

    @Provides
    @Singleton
    fun provideErrorHandler(): ErrorHandler{
        return ErrorHandler()
    }

    @Provides
    @Singleton
    fun provideGetExercisesByMuscleUseCase(
        remoteRepository: RemoteRepository,
        errorHandler: ErrorHandler
    ): GetExercisesByMuscleUseCase{
        return GetExercisesByMuscleUseCaseImpl(remoteRepository, errorHandler)
    }

    @Provides
    @Singleton
    fun provideGetExercisesByTypeUseCase(
        remoteRepository: RemoteRepository,
        errorHandler: ErrorHandler
    ): GetExercisesByTypeUseCase{
        return GetExercisesByTypeUseCaseImpl(remoteRepository, errorHandler)
    }

    @Provides
    @Singleton
    fun provideGetExercisesByDifficultyUseCase(
        remoteRepository: RemoteRepository,
        errorHandler: ErrorHandler
    ): GetExercisesByDifficultyUseCase{
        return GetExercisesByDifficultyUseCaseImpl(remoteRepository, errorHandler)
    }

    @Provides
    @Singleton
    fun provideGetExercisesByNameUseCase(
        remoteRepository: RemoteRepository,
        errorHandler: ErrorHandler
    ): GetExercisesByNameUseCase{
        return GetExercisesByNameUseCaseImpl(remoteRepository, errorHandler)
    }
}