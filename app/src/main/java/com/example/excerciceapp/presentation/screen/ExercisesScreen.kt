package com.example.excerciceapp.presentation.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.excerciceapp.domain.model.Exercise
import com.example.excerciceapp.presentation.navigation.ScreenNavigationItem
import com.example.excerciceapp.presentation.screen.common.ErrorText
import com.example.excerciceapp.presentation.viewmodels.ExercisesScreenViewModel


@Composable
fun ExercisesScreen(
    modifier: Modifier,
    exercisesScreenViewModel: ExercisesScreenViewModel = hiltViewModel(),
    onNavigate: (Exercise) -> Unit
){
    val exercises by exercisesScreenViewModel.exerciseListState.collectAsState()
    val exercisesError by exercisesScreenViewModel.exerciseErrorState.collectAsState()
    val exercisesIsLoading by exercisesScreenViewModel.exerciseListIsLoading.collectAsState()

    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ){
        when{
            exercises.isNotEmpty() -> {
                LazyColumn(
                    Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(vertical = 8.dp)
                ){
                    itemsIndexed(exercises){ index, exercise   ->
                        ExerciseItem(
                            modifier = Modifier,
                            exercise = exercise,
                            index = index
                        ){
                            onNavigate(it)
                        }
                        HorizontalDivider()
                    }
                }
            }
            exercisesError.asString().isNotEmpty() -> {
                ErrorText(text = exercisesError)
            }
            exercisesIsLoading -> {
                CircularProgressIndicator()
            }
        }
    }
}