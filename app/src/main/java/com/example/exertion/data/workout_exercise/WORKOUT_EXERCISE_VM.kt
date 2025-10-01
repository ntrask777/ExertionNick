package com.example.exertion.data.workout_exercise

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.exertion.data.EXERTION_DB
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WORKOUT_EXERCISE_VM(application: Application): AndroidViewModel(application) {
    private val read_all_workout_exercise_data: LiveData<List<WORKOUT_EXERCISE>>
    private val workout_exercise_repository: WORKOUT_EXERCISE_REPO

    init {
        val workoutExerciseDao = EXERTION_DB.getDatabase(application).workoutExerciseDao()
        workout_exercise_repository = WORKOUT_EXERCISE_REPO(workoutExerciseDao)
        read_all_workout_exercise_data = workout_exercise_repository.read_all_workout_exercise_data
    }

    fun addWorkoutExercise(workoutExercise: WORKOUT_EXERCISE) {
        viewModelScope.launch(Dispatchers.IO) {
            workout_exercise_repository.addWorkoutExercise(workoutExercise)
        }
    }
}