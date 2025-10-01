package com.example.exertion.data.workout_metric_snapshot

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface WORKOUT_METRIC_SNAPSHOT_DAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addWorkoutMetricSnapshot(workoutMetricSnapshot: WORKOUT_METRIC_SNAPSHOT)

    @Query(
        "SELECT * FROM WORKOUT_METRIC_SNAPSHOT ORDER BY snapshot_id ASC"
    )
    fun readAllWorkoutMetricSnapshotData(): LiveData<List<WORKOUT_METRIC_SNAPSHOT>>
}