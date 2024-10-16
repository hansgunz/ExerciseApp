package com.example.excerciceapp.presentation.navigation

import android.net.Uri
import android.os.Bundle
import androidx.navigation.NavType
import com.example.excerciceapp.domain.model.Exercise
import com.example.excerciceapp.presentation.screen.ExerciseSearchItem
import com.example.excerciceapp.presentation.viewmodels.actions.ExercisesByAction
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

object CustomNavType {

    val exerciseType = object : NavType<Exercise>(
        isNullableAllowed = false
    ){
        override fun get(bundle: Bundle, key: String): Exercise? {
            return Json.decodeFromString(bundle.getString(key) ?: return null)
        }

        override fun parseValue(value: String): Exercise {
            return Json.decodeFromString(Uri.decode(value))
        }

        override fun serializeAsValue(value: Exercise): String {
            return Uri.encode(Json.encodeToString(value))
        }

        override fun put(bundle: Bundle, key: String, value: Exercise) {
            bundle.putString(key, Json.encodeToString(value))
        }

    }

    val exerciseSearchType = object : NavType<ExerciseSearchItem>(
        isNullableAllowed = false
    ){
        override fun get(bundle: Bundle, key: String): ExerciseSearchItem? {
            return Json.decodeFromString(bundle.getString(key) ?: return null)
        }

        override fun parseValue(value: String): ExerciseSearchItem {
            return Json.decodeFromString(Uri.decode(value))
        }

        override fun serializeAsValue(value: ExerciseSearchItem): String {
            return Uri.encode(Json.encodeToString(value))
        }

        override fun put(bundle: Bundle, key: String, value: ExerciseSearchItem) {
            bundle.putString(key, Json.encodeToString(value))
        }
    }

    val exercisesByAction = object : NavType<ExercisesByAction>(
        isNullableAllowed = false
    ){
        override fun get(bundle: Bundle, key: String): ExercisesByAction? {
            return Json.decodeFromString(bundle.getString(key) ?: return null)
        }

        override fun parseValue(value: String): ExercisesByAction {
            return Json.decodeFromString(Uri.decode(value))
        }

        override fun serializeAsValue(value: ExercisesByAction): String {
            return Uri.encode(Json.encodeToString(value))
        }

        override fun put(bundle: Bundle, key: String, value: ExercisesByAction) {
            bundle.putString(key, Json.encodeToString(value))
        }

    }
}