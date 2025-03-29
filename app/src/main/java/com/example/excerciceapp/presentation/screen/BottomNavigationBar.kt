package com.example.excerciceapp.presentation.screen

import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.excerciceapp.R
import com.example.excerciceapp.presentation.navigation.ScreenNavigationItem

@Composable
fun BottomNavigationBar(
    items: List<ScreenNavigationItem>,
    navHostController: NavHostController
){
    BottomAppBar(
        contentColor = MaterialTheme.colorScheme.secondary,
        tonalElevation = 8.dp,
        actions = {
            items.forEach {
                Column(
                    modifier = Modifier.weight(1F),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    IconButton(
                        onClick = { navHostController.navigate(it) },
                    ) {
                        Icon(
                            painter = painterResource(it.icon),
                            contentDescription = "",
                            modifier = Modifier.size(32.dp)
                        )
                    }
                    Text(
                        text = it.title,
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }
        }
    )
}