package com.example.excerciceapp.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.excerciceapp.domain.model.Exercise
import com.example.excerciceapp.domain.resource.DataError
import com.example.excerciceapp.domain.resource.Result
import com.example.excerciceapp.domain.usecase.GetExercisesByDifficultyUseCase
import com.example.excerciceapp.domain.usecase.GetExercisesByMuscleUseCase
import com.example.excerciceapp.domain.usecase.GetExercisesByNameUseCase
import com.example.excerciceapp.domain.usecase.GetExercisesByTypeUseCase
import com.example.excerciceapp.presentation.viewmodels.actions.ExercisesByAction
import com.example.excerciceapp.presentation.viewmodels.states.ExercisesByState
import com.example.excerciceapp.presentation.viewmodels.utils.asUiText
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ExercisesByScreenViewModel @Inject constructor(
    private val getExercisesByMuscleUseCase: GetExercisesByMuscleUseCase,
    private val getExercisesByTypeUseCase: GetExercisesByTypeUseCase,
    private val getExercisesByDifficultyUseCase: GetExercisesByDifficultyUseCase,
    private val getExercisesByNameUseCase: GetExercisesByNameUseCase
): ViewModel() {

    private val _exercisesByState: MutableStateFlow<ExercisesByState> = MutableStateFlow(
        ExercisesByState()
    )
    val exercisesByState = _exercisesByState.asStateFlow()

    fun onAction(action: ExercisesByAction, query: String){
        when(action){
            ExercisesByAction.ByDifficulty -> {
                fetchExercisesByDifficulty(query)
            }
            ExercisesByAction.ByMuscle -> {
                fetchExercisesByMuscle(query)
            }
            ExercisesByAction.ByType -> {
                fetchExercisesByType(query)
            }
            ExercisesByAction.ByName -> {
                fetchExercisesByName(query)
            }
        }
    }

    private fun fetchExercisesByMuscle(muscle: String){
        viewModelScope.launch(Dispatchers.IO) {
            getExercisesByMuscleUseCase(muscle).collect{ result ->
                resultHandler(result)
            }
        }
    }

    private fun fetchExercisesByType(type: String){
        viewModelScope.launch(Dispatchers.IO) {
            getExercisesByTypeUseCase(type).collect{ result ->
                resultHandler(result)
            }
        }
    }

    private fun fetchExercisesByDifficulty(difficulty: String){
        viewModelScope.launch(Dispatchers.IO) {
            getExercisesByDifficultyUseCase(difficulty).collect{ result ->
                resultHandler(result)
            }
        }
    }

    private fun fetchExercisesByName(name: String){
        viewModelScope.launch(Dispatchers.IO) {
            getExercisesByNameUseCase(name).collect{ result ->
                resultHandler(result)
            }
        }
    }

    private fun resultHandler(result: Result<List<Exercise>, DataError.Network>){
        when(result){
            is Result.Error -> {
                setErrorState(result.error)
            }
            is Result.Loading -> {
                setLoadingState()
            }
            is Result.Success -> {
                setSuccessState(result.data)
            }
        }
    }

    private fun setErrorState(error: DataError.Network){
        _exercisesByState.update { state ->
            state.copy(exercisesIsLoading = false, exercisesError = error.asUiText())
        }
    }

    private fun setLoadingState(){
        _exercisesByState.update { state ->
            state.copy(exercisesIsLoading = true)
        }
    }

    private fun setSuccessState(exercises: List<Exercise>){
        _exercisesByState.update { state ->
            state.copy(exercisesIsLoading = false, exercisesList = exercises)
        }
    }
}