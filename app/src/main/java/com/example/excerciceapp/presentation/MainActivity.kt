package com.example.excerciceapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.excerciceapp.presentation.navigation.NavGraph
import com.example.excerciceapp.presentation.navigation.ScreenNavigationItem
import com.example.excerciceapp.presentation.screen.BottomNavigationBar
import com.example.excerciceapp.presentation.screen.TopBar
import com.example.excerciceapp.presentation.theme.ExcerciceAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            ExcerciceAppTheme {
                Scaffold(
                    topBar = { TopBar() },
                    bottomBar = {
                        BottomNavigationBar(
                            items = getBottomNavigationItems(),
                            navHostController = navController
                        )
                    }
                ){ innerPadding ->
                    NavGraph(
                        Modifier.padding(innerPadding),
                        navController = navController
                    )
                }
            }
        }
    }
}

private fun getBottomNavigationItems(): List<ScreenNavigationItem>{
    return listOf(
        ScreenNavigationItem.ExercisesListNavigationItem,
        ScreenNavigationItem.ExerciseSearchNavigationItem
    )
}