package com.example.exertion.data.workout_metric_snapshot

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.exertion.data.EXERTION_DB
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WORKOUT_METRIC_SNAPSHOT_VM(application: Application): AndroidViewModel(application) {
    private val read_all_workout_metric_snapshot_data: LiveData<List<WORKOUT_METRIC_SNAPSHOT>>
    private val workout_metric_snapshot_repository: WORKOUT_METRIC_SNAPSHOT_REPO

    init {
        val workoutMetricSnapshotDao = EXERTION_DB.getDatabase(application).workoutMetricSnapshotDao()
        workout_metric_snapshot_repository = WORKOUT_METRIC_SNAPSHOT_REPO(workoutMetricSnapshotDao)
        read_all_workout_metric_snapshot_data = workout_metric_snapshot_repository.read_all_workout_metric_snapshot_data
    }

    fun addWorkoutMetricSnapshot(workoutMetricSnapshot: WORKOUT_METRIC_SNAPSHOT) {
        viewModelScope.launch(Dispatchers.IO) {
            workout_metric_snapshot_repository.addWorkoutMetricSnapshot(workoutMetricSnapshot)
        }
    }
}