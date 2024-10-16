package com.example.excerciceapp.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.excerciceapp.domain.model.Exercise
import com.example.excerciceapp.domain.resource.DataError
import com.example.excerciceapp.domain.resource.Result
import com.example.excerciceapp.domain.usecase.FetchExercisesUseCase
import com.example.excerciceapp.presentation.viewmodels.utils.UiText
import com.example.excerciceapp.presentation.viewmodels.utils.asUiText
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ExercisesScreenViewModel @Inject constructor(
    private val fetchExercisesUseCase: FetchExercisesUseCase
): ViewModel() {

    private val _exerciseListState: MutableStateFlow<List<Exercise>> = MutableStateFlow(emptyList())
    val exerciseListState = _exerciseListState.asStateFlow()

    private val _exerciseErrorState: MutableStateFlow<UiText> = MutableStateFlow(UiText.DynamicString(""))
    val exerciseErrorState = _exerciseErrorState.asStateFlow()

    private val _exerciseListIsLoading: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val exerciseListIsLoading = _exerciseListIsLoading.asStateFlow()

    init {
        fetchExercises()
    }

    private fun fetchExercises(){
        viewModelScope.launch(Dispatchers.IO) {
            fetchExercisesUseCase().collect{ result ->
                when(result){
                    is Result.Error -> {
                        setExerciseListIsLoadingState(false)
                        setExerciseListErrorState(result.error)
                    }
                    is Result.Loading -> {
                        setExerciseListIsLoadingState(true)
                    }
                    is Result.Success -> {
                        setExerciseListIsLoadingState(false)
                        setExerciseListState(result.data)
                    }
                }
            }
        }
    }

    private fun setExerciseListState(exercises: List<Exercise>){
        _exerciseListState.value = exercises
    }

    private fun setExerciseListErrorState(error: DataError.Network){
        _exerciseErrorState.value = error.asUiText()
    }

    private fun setExerciseListIsLoadingState(isLoading: Boolean){
        _exerciseListIsLoading.value = isLoading
    }
}