package com.example.exertion.data.exercise_metric_snapshot

import androidx.lifecycle.LiveData

class EXERCISE_METRIC_SNAPSHOT_REPO(private val exerciseMetricSnapshotDao: EXERCISE_METRIC_SNAPSHOT_DAO) {
    val read_all_exercise_metric_snapshot_data: LiveData<List<EXERCISE_METRIC_SNAPSHOT>> = exerciseMetricSnapshotDao.readAllExerciseMetricSnapshotData()

    suspend fun addExerciseMetricSnapshot(exerciseMetricSnapshot: EXERCISE_METRIC_SNAPSHOT) {
        exerciseMetricSnapshotDao.addExerciseMetricSnapshot(exerciseMetricSnapshot)
    }
}