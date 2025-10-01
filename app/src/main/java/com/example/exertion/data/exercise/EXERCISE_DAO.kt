package com.example.exertion.data.exercise

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface EXERCISE_DAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addExercise(exercise: EXERCISE)

    @Query(
        "SELECT * FROM EXERCISE ORDER BY exercise_id ASC"
    )
    fun readAllExerciseData(): LiveData<List<EXERCISE>>
}