package com.example.excerciceapp.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun SearchScreen(
    modifier: Modifier,
    onClick: (ExerciseSearchItem) -> Unit
){
        Column (
            modifier = modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier.weight(1F)
            ) {
                Card(
                    onClick = { onClick(ExerciseSearchItem.ExerciseByName) },
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(1F),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    CardContent(text = ExerciseSearchItem.ExerciseByName.text)
                }
                Spacer(modifier = Modifier.width(2.dp))
                Card(
                    onClick = { onClick(ExerciseSearchItem.ExerciseByType) },
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(1F),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    CardContent(text = ExerciseSearchItem.ExerciseByType.text)
                }
            }
            Spacer(modifier = Modifier.height(2.dp))
            Row(
                modifier = Modifier.weight(1F)
            ) {
                Card(
                    onClick = { onClick(ExerciseSearchItem.ExerciseByMuscle) },
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(1F),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    CardContent(text = ExerciseSearchItem.ExerciseByMuscle.text)
                }
                Spacer(modifier = Modifier.width(2.dp))
                Card(
                    onClick = { onClick(ExerciseSearchItem.ExerciseByDifficulty) },
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(1F),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    CardContent(text = ExerciseSearchItem.ExerciseByDifficulty.text)
                }
            }
        }
}

@Composable
private fun CardContent(text: String){
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Text(
            text = text,
            textAlign = TextAlign.Center
        )
    }
}