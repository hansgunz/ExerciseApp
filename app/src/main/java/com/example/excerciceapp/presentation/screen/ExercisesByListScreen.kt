package com.example.excerciceapp.presentation.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.excerciceapp.R
import com.example.excerciceapp.domain.model.Exercise
import com.example.excerciceapp.presentation.screen.common.ErrorText
import com.example.excerciceapp.presentation.viewmodels.ExercisesByScreenViewModel
import com.example.excerciceapp.presentation.viewmodels.actions.ExercisesByAction
import com.example.excerciceapp.presentation.viewmodels.utils.UiText

@Composable
fun ExercisesByListScreen(
    modifier: Modifier,
    exerciseQuery: String,
    exercisesByAction: ExercisesByAction,
    exercisesByScreenViewModel: ExercisesByScreenViewModel = hiltViewModel(),
    onItemClick: (Exercise) -> Unit
){
    LaunchedEffect(key1 = true){
        exercisesByScreenViewModel.onAction(exercisesByAction, exerciseQuery)
    }

    val state = exercisesByScreenViewModel.exercisesByState.collectAsState()

    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ){
        with(state.value){
                    when{
                        exercisesList.isNotEmpty() ->{
                            when(exercisesByAction) {
                                ExercisesByAction.BY_NAME -> {
                                    ExerciseDetailScreen(exercise = exercisesList.first())
                                }
                                else -> {
                                    LazyColumn(
                                        modifier = Modifier.fillMaxSize(),
                                        contentPadding = PaddingValues(vertical = 8.dp)
                                    ){
                                        itemsIndexed(exercisesList){ index, exercise ->
                                            ExerciseItem(
                                                modifier = Modifier,
                                                exercise = exercise,
                                                index = index
                                            ){
                                                onItemClick(it)
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        exercisesIsLoading -> {
                            CircularProgressIndicator()
                        }
                        exercisesError.asString().isNotEmpty() -> {
                            ErrorText(text = exercisesError)
                        }
                        else ->{
                            ErrorText(text = UiText.StringResource(R.string.exercise_not_found_text))
                        }
                    }
        }
    }
}