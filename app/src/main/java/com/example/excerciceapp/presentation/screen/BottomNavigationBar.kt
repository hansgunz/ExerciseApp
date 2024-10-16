package com.example.excerciceapp.presentation.screen

import androidx.compose.foundation.layout.size
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
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
                IconButton(
                    onClick = { navHostController.navigate(it) },
                    modifier = Modifier.weight(1F)
                ) {
                    Icon(
                        painter = painterResource(it.icon),
                        contentDescription = "",
                        modifier = Modifier.size(32.dp)
                    )
                }
            }
        }
    )
}