package com.example.exertion.data.exercise_metric_snapshot

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.exertion.data.EXERTION_DB
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EXERCISE_METRIC_SNAPSHOT_VM(application: Application): AndroidViewModel(application) {
    private val read_all_exercise_metric_snapshot_data: LiveData<List<EXERCISE_METRIC_SNAPSHOT>>
    private val exercise_metric_snapshot_repository: EXERCISE_METRIC_SNAPSHOT_REPO

    init {
        val exerciseMetricSnapshotDao = EXERTION_DB.getDatabase(application).exerciseMetricSnapshotDao()
        exercise_metric_snapshot_repository = EXERCISE_METRIC_SNAPSHOT_REPO(exerciseMetricSnapshotDao)
        read_all_exercise_metric_snapshot_data = exercise_metric_snapshot_repository.read_all_exercise_metric_snapshot_data
    }

    fun addExerciseMetricSnapshot(exerciseMetricSnapshot: EXERCISE_METRIC_SNAPSHOT) {
        viewModelScope.launch(Dispatchers.IO) {
            exercise_metric_snapshot_repository.addExerciseMetricSnapshot(exerciseMetricSnapshot)
        }
    }
}