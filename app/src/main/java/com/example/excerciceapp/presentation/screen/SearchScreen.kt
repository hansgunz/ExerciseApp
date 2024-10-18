package com.example.excerciceapp.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
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
import com.example.excerciceapp.presentation.screen.items.ExerciseGroup

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
                CardComponent(
                    cardText = ExerciseSearchItem.ExerciseByName.text
                ){
                    onClick(ExerciseSearchItem.ExerciseByName)
                }
                Spacer(modifier = Modifier.width(2.dp))
                CardComponent(
                    cardText = ExerciseSearchItem.ExerciseByType.text
                ){
                    onClick(ExerciseSearchItem.ExerciseByType)
                }
            }
            Spacer(modifier = Modifier.height(2.dp))
            Row(
                modifier = Modifier.weight(1F)
            ) {
                CardComponent(
                    cardText = ExerciseSearchItem.ExerciseByMuscle.text
                ){
                    onClick(ExerciseSearchItem.ExerciseByMuscle)
                }
                Spacer(modifier = Modifier.width(2.dp))
                CardComponent(cardText = ExerciseSearchItem.ExerciseByDifficulty.text){
                    onClick(ExerciseSearchItem.ExerciseByDifficulty)
                }
            }
        }
}

@Composable
private fun RowScope.CardComponent(
    cardText: String,
    onCardClick: () -> Unit
){
    Card(
        onClick = { onCardClick() },
        modifier = Modifier
            .fillMaxSize()
            .weight(1F),
        shape = RoundedCornerShape(12.dp)
    ) {
        CardContent(text = cardText)
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