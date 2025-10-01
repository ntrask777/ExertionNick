package com.example.exertion.data.workout_exercise

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface WORKOUT_EXERCISE_DAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addWorkoutExercise(workoutExercise: WORKOUT_EXERCISE)

    @Query(
        "SELECT * FROM WORKOUT_EXERCISE ORDER BY workout_exercise_id ASC"
    )
    fun readAllWorkoutExerciseData(): LiveData<List<WORKOUT_EXERCISE>>
}