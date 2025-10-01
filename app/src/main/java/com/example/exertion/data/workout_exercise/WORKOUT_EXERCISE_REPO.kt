package com.example.exertion.data.workout_exercise

import androidx.lifecycle.LiveData

class WORKOUT_EXERCISE_REPO(private val workoutExerciseDAO: WORKOUT_EXERCISE_DAO) {
    val read_all_workout_exercise_data: LiveData<List<WORKOUT_EXERCISE>> = workoutExerciseDAO.readAllWorkoutExerciseData()

    suspend fun addWorkoutExercise(workoutExercise: WORKOUT_EXERCISE) {
        workoutExerciseDAO.addWorkoutExercise(workoutExercise)
    }
}