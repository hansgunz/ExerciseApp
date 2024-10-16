package com.example.excerciceapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.example.excerciceapp.domain.model.Exercise
import com.example.excerciceapp.presentation.screen.ExerciseByScreen
import com.example.excerciceapp.presentation.screen.ExerciseDetailScreen
import com.example.excerciceapp.presentation.screen.ExerciseSearchItem
import com.example.excerciceapp.presentation.screen.ExercisesByListScreen
import com.example.excerciceapp.presentation.screen.ExercisesScreen
import com.example.excerciceapp.presentation.screen.SearchScreen
import com.example.excerciceapp.presentation.viewmodels.actions.ExercisesByAction
import kotlin.reflect.typeOf


@Composable
fun NavGraph(
    modifier: Modifier,
    navController: NavHostController
){
    NavHost(navController = navController, startDestination = ScreenNavigationItem.ExercisesListNavigationItem ){
        composable<ScreenNavigationItem.ExercisesListNavigationItem>{
            ExercisesScreen(
                modifier = modifier,
                navController = navController
            )
        }
        composable<ScreenNavigationItem.ExerciseDetailSNavigationItem>(
            typeMap = mapOf(
                typeOf<Exercise>() to CustomNavType.exerciseType
            )
        ) {
            val arguments = 
                it.toRoute<ScreenNavigationItem.ExerciseDetailSNavigationItem>()
            ExerciseDetailScreen(
                modifier = modifier,
                exercise = arguments.exercise)
        }
        composable<ScreenNavigationItem.ExerciseSearchNavigationItem> {
            SearchScreen(modifier = modifier){
                navController.navigate(ScreenNavigationItem.ExercisesByNavigationItem(it))
            }
        }
        composable<ScreenNavigationItem.ExercisesByNavigationItem>(
            typeMap = mapOf(
                typeOf<ExerciseSearchItem>() to CustomNavType.exerciseSearchType
            )
        ) {
            val exerciseSearchItem = it.toRoute<ScreenNavigationItem.ExercisesByNavigationItem>().exercisesSearchItem

            ExerciseByScreen(
                modifier = modifier,
                exerciseSearchItem = exerciseSearchItem,
            ){ query, action ->
                navController
                    .navigate(
                        ScreenNavigationItem.ExerciseListByNavigationItem(query = query, action = action)
                    )
            }
        }
        composable<ScreenNavigationItem.ExerciseListByNavigationItem>(
            typeMap = mapOf(
                typeOf<ExercisesByAction>() to CustomNavType.exercisesByAction
            )
        ) {
            val args = it.toRoute<ScreenNavigationItem.ExerciseListByNavigationItem>()
            val query = args.query
            val action = args.action

            ExercisesByListScreen(
                modifier = modifier,
                exerciseQuery = query,
                exercisesByAction = action,
            ){
                navController.navigate(ScreenNavigationItem.ExerciseDetailSNavigationItem(it))
            }
        }
    }
}