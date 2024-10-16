package com.example.excerciceapp.presentation.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.excerciceapp.R
import com.example.excerciceapp.domain.model.Exercise

@Composable
fun ExerciseItem(
    modifier: Modifier,
    exercise: Exercise,
    index: Int,
    onClickItem: (Exercise) -> Unit
){
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clickable {
                onClickItem(exercise)
            },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = (index + 1).toString(),
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier
                .padding(horizontal = 8.dp)
        )
        Column(
            modifier = Modifier
                .padding(horizontal = 8.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = stringResource(id = R.string.exercise_name_text, exercise.name),
                style = MaterialTheme.typography.titleSmall,
                color = colorResource(id = R.color.black),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = stringResource(id = R.string.exercise_muscle_text, exercise.muscle),
                style = MaterialTheme.typography.bodySmall,
                color = colorResource(id = R.color.grey),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}