package com.example.exertion.data.exercise

import androidx.lifecycle.LiveData

class EXERCISE_REPO(private val exerciseDao: EXERCISE_DAO) {
    val read_all_exercise_data: LiveData<List<EXERCISE>> = exerciseDao.readAllExerciseData()

    suspend fun addExercise(exercise: EXERCISE) {
        exerciseDao.addExercise(exercise)
    }
}