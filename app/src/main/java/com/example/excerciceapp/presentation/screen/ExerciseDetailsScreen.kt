package com.example.excerciceapp.presentation.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.excerciceapp.R
import com.example.excerciceapp.domain.model.Exercise
import com.example.excerciceapp.presentation.theme.ExcerciceAppTheme

@Composable
fun ExerciseDetailScreen(
    modifier: Modifier = Modifier,
    exercise: Exercise
){
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        ExerciseDetailHeaderContent(
            modifier = Modifier,
            exercise = exercise
        )
        Spacer(modifier = Modifier.height(16.dp))
        ExerciseDetailInstructionsContent(
            modifier = Modifier,
            exercise = exercise
         )
    }
}

@Composable
private fun ExerciseDetailHeaderContent(
    modifier: Modifier,
    exercise: Exercise
){
    Card(
        modifier = modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(12.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = exercise.name,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.primary
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = stringResource(id = R.string.exercise_muscle_text, exercise.muscle),
                    style = MaterialTheme.typography.bodyMedium,
                    color = colorResource(id = R.color.black)
                )
                Text(
                    text = stringResource(id = R.string.exercise_difficulty_text, exercise.difficulty),
                    style = MaterialTheme.typography.bodyMedium,
                    color = colorResource(id = R.color.grey)
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = stringResource(id = R.string.exercise_type_text, exercise.type),
                    style = MaterialTheme.typography.bodyMedium,
                    color = colorResource(id = R.color.black)
                )
                Text(
                    text = stringResource(id = R.string.exercise_equipment_text, exercise.equipment),
                    style = MaterialTheme.typography.bodyMedium,
                    color = colorResource(id = R.color.grey)
                )
            }
        }
    }
}

@Composable
private fun ExerciseDetailInstructionsContent(
    modifier: Modifier,
    exercise: Exercise
){
    Card(
        modifier = modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState()),
        shape = RoundedCornerShape(12.dp)
    ){
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = stringResource(id = R.string.instructions_text),
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.primary,
                textAlign = TextAlign.Center
            )
            Text(
                text = exercise.instructions,
                style = MaterialTheme.typography.bodyMedium,
                color = colorResource(id = R.color.black)
            )
        }
    }
}

@Composable
@Preview(
    showBackground = true,
    showSystemUi = true
)
fun ExerciseDetailScreenPreview(){
    ExcerciceAppTheme{
         ExerciseDetailScreen(
            exercise = Exercise(
                name = "Incline Hammer Curls",
                type = "strength",
                muscle = "biceps",
                equipment = "dumbbell",
                difficulty = "beginner",
                instructions = "Seat yourself on an incline bench with a dumbbell in each hand. You should pressed firmly against he back with your feet together. Allow the dumbbells to hang straight down at your side, holding them with a neutral grip. This will be your starting position. Initiate the movement by flexing at the elbow, attempting to keep the upper arm stationary. Continue to the top of the movement and pause, then slowly return to the start position."
            )
        )
    }
}