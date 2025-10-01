package com.example.exertion.data.workout_metric_snapshot

import androidx.lifecycle.LiveData

class WORKOUT_METRIC_SNAPSHOT_REPO(private val workoutMetricSnapshotDao: WORKOUT_METRIC_SNAPSHOT_DAO) {
    val read_all_workout_metric_snapshot_data: LiveData<List<WORKOUT_METRIC_SNAPSHOT>> = workoutMetricSnapshotDao.readAllWorkoutMetricSnapshotData()

    suspend fun addWorkoutMetricSnapshot(workoutMetricSnapshot: WORKOUT_METRIC_SNAPSHOT) {
        workoutMetricSnapshotDao.addWorkoutMetricSnapshot(workoutMetricSnapshot)
    }
}