package com.example.exertion.data.exercise_metric_snapshot

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface EXERCISE_METRIC_SNAPSHOT_DAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addExerciseMetricSnapshot(exerciseMetricSnapshot: EXERCISE_METRIC_SNAPSHOT)

    @Query(
        "SELECT * FROM EXERCISE_METRIC_SNAPSHOT ORDER BY snapshot_id ASC"
    )
    fun readAllExerciseMetricSnapshotData(): LiveData<List<EXERCISE_METRIC_SNAPSHOT>>
}