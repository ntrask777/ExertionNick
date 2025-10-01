package com.example.exertion.data.exercise

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.exertion.data.EXERTION_DB
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EXERCISE_VM(application: Application): AndroidViewModel(application) {
    private val read_all_exercise_data: LiveData<List<EXERCISE>>
    private val exercise_repository: EXERCISE_REPO

    init {
        val exerciseDao = EXERTION_DB.getDatabase(application).exerciseDao()
        exercise_repository = EXERCISE_REPO(exerciseDao)
        read_all_exercise_data = exercise_repository.read_all_exercise_data
    }

    fun addExercise(exercise: EXERCISE) {
        viewModelScope.launch(Dispatchers.IO) {
            exercise_repository.addExercise(exercise)
        }
    }
}