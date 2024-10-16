package com.example.excerciceapp.presentation.screen.items

sealed interface ExerciseGroup{
    sealed class MuscleGroup(val name: String): ExerciseGroup {
        data object Abdominals: MuscleGroup(name = "abdominals")
        data object Abductors: MuscleGroup(name = "abductors")
        data object Adductors: MuscleGroup(name = "adductors")
        data object Biceps: MuscleGroup(name = "biceps")
        data object Calves: MuscleGroup(name = "calves")
        data object Chest: MuscleGroup(name = "chest")
        data object Forearms: MuscleGroup(name = "forearms")
        data object Glutes: MuscleGroup(name = "glutes")
        data object Hamstrings: MuscleGroup(name = "hamstrings")
        data object Lats: MuscleGroup(name = "lats")
        data object LowerBack: MuscleGroup(name = "lower_back")
        data object MiddleBack: MuscleGroup(name = "middle_back")
        data object Neck: MuscleGroup(name = "neck")
        data object Quadriceps: MuscleGroup(name = "Quadriceps")
        data object Traps: MuscleGroup(name = "traps")
        data object Triceps: MuscleGroup(name = "triceps")
    }

    sealed class TypeGroup(val name: String): ExerciseGroup{
        data object Cardio: TypeGroup(name = "cardio")
        data object OlympicWeightlifting: TypeGroup(name = "olympic_weightlifting")
        data object Plyometrics: TypeGroup(name = "plyometrics")
        data object Powerlifting: TypeGroup(name = "powerlifting")
        data object Strength: TypeGroup(name = "strength")
        data object Stretching: TypeGroup(name = "stretching")
        data object Strongman: TypeGroup(name = "strongman")
    }

    sealed class DifficultyGroup(val name: String): ExerciseGroup{
        data object Beginner: DifficultyGroup(name = "beginner")
        data object Intermediate: DifficultyGroup(name = "intermediate")
        data object Expert: DifficultyGroup(name = "expert")
    }
}

