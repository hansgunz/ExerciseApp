package com.example.excerciceapp.presentation.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.excerciceapp.presentation.screen.items.ExerciseGroup
import com.example.excerciceapp.presentation.viewmodels.actions.ExercisesByAction

@Composable
fun ExerciseByScreen(
    modifier: Modifier,
    exerciseSearchItem: ExerciseSearchItem,
    onGroupClick: (String, ExercisesByAction) -> Unit
){
    var exercisesByDifficulty by remember {
        mutableStateOf<List<ExerciseGroup.DifficultyGroup>>(emptyList())
    }
    var exercisesByMuscle by remember {
        mutableStateOf<List<ExerciseGroup.MuscleGroup>>(emptyList())
    }

    var exercisesByType by remember {
        mutableStateOf<List<ExerciseGroup.TypeGroup>>(emptyList())
    }
    LaunchedEffect(key1 = true){
        exercisesByDifficulty = getExercisesByDifficulty()
        exercisesByMuscle = getExerciseByMuscleList()
        exercisesByType = getExercisesByTypeList()
    }
    Box(modifier = modifier
        .fillMaxSize()
        .padding(16.dp),
        contentAlignment = Alignment.Center
    ){
            when(exerciseSearchItem){
                ExerciseSearchItem.ExerciseByDifficulty -> {
                    LazyColumn(modifier = Modifier.fillMaxSize()){
                        items(exercisesByDifficulty){ group ->
                            ExerciseByItem(
                                modifier = Modifier,
                                exerciseGroup = group
                            ){
                                onGroupClick(it, ExercisesByAction.BY_DIFFICULTY)
                            }
                            HorizontalDivider()
                        }
                    }
                }
                ExerciseSearchItem.ExerciseByMuscle -> {
                    LazyColumn(modifier = Modifier.fillMaxSize()){
                        items(exercisesByMuscle){
                            ExerciseByItem(
                                modifier = Modifier,
                                exerciseGroup = it
                            ){
                                onGroupClick(it, ExercisesByAction.BY_MUSCLE)
                            }
                            HorizontalDivider()
                        }
                    }
                }
                ExerciseSearchItem.ExerciseByName -> {
                    SearchFieldScreen(modifier = Modifier){
                        onGroupClick(it, ExercisesByAction.BY_NAME)
                    }
                }
                ExerciseSearchItem.ExerciseByType -> {
                    LazyColumn(modifier = Modifier.fillMaxSize()){
                        items(exercisesByType){
                            ExerciseByItem(
                                modifier = Modifier,
                                exerciseGroup = it
                            ){
                                onGroupClick(it, ExercisesByAction.BY_TYPE)
                            }
                            HorizontalDivider()
                        }
                    }
                }
            }
    }
}

private fun getExerciseByMuscleList(): List<ExerciseGroup.MuscleGroup>{
    return listOf(
        ExerciseGroup.MuscleGroup.Abductors,
        ExerciseGroup.MuscleGroup.Abdominals,
        ExerciseGroup.MuscleGroup.Adductors,
        ExerciseGroup.MuscleGroup.Biceps,
        ExerciseGroup.MuscleGroup.Calves,
        ExerciseGroup.MuscleGroup.Chest,
        ExerciseGroup.MuscleGroup.Forearms,
        ExerciseGroup.MuscleGroup.Glutes,
        ExerciseGroup.MuscleGroup.Hamstrings,
        ExerciseGroup.MuscleGroup.Lats,
        ExerciseGroup.MuscleGroup.LowerBack,
        ExerciseGroup.MuscleGroup.MiddleBack,
        ExerciseGroup.MuscleGroup.Neck,
        ExerciseGroup.MuscleGroup.Quadriceps,
        ExerciseGroup.MuscleGroup.Traps,
        ExerciseGroup.MuscleGroup.Triceps
    )
}

private fun getExercisesByTypeList(): List<ExerciseGroup.TypeGroup>{
    return listOf(
        ExerciseGroup.TypeGroup.Cardio,
        ExerciseGroup.TypeGroup.OlympicWeightlifting,
        ExerciseGroup.TypeGroup.Plyometrics,
        ExerciseGroup.TypeGroup.Powerlifting,
        ExerciseGroup.TypeGroup.Strength,
        ExerciseGroup.TypeGroup.Stretching,
        ExerciseGroup.TypeGroup.Strongman,
    )
}

private fun getExercisesByDifficulty(): List<ExerciseGroup.DifficultyGroup>{
    return listOf(
        ExerciseGroup.DifficultyGroup.Beginner,
        ExerciseGroup.DifficultyGroup.Expert,
        ExerciseGroup.DifficultyGroup.Intermediate
    )
}