package com.example.excerciceapp.presentation.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
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
import com.example.excerciceapp.presentation.screen.utils.exerciseGroupFormat

@Composable
fun ExerciseByItem(
    modifier: Modifier,
    exerciseGroup: ExerciseGroup,
    onItemClick: (String) -> Unit
){
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable {
                when (exerciseGroup) {
                    is ExerciseGroup.MuscleGroup -> {
                        onItemClick(exerciseGroup.name)
                    }

                    is ExerciseGroup.TypeGroup -> {
                        onItemClick(exerciseGroup.name)
                    }

                    is ExerciseGroup.DifficultyGroup -> {
                        onItemClick(exerciseGroup.name)
                    }
                }
            },
        contentAlignment = Alignment.Center
    ){
        Text(
            text = when(exerciseGroup){
                is ExerciseGroup.MuscleGroup ->{
                    exerciseGroup.name.exerciseGroupFormat()
                }
                is ExerciseGroup.TypeGroup -> {
                    exerciseGroup.name.exerciseGroupFormat()
                }
                is ExerciseGroup.DifficultyGroup -> {
                    exerciseGroup.name.exerciseGroupFormat()
                }
                                      },
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.primary
        )
    }
}
