package com.example.exertion.data.daily_user_metric_snapshot

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.exertion.data.EXERTION_DB

class DAILY_USER_METRIC_SNAPSHOT_VM(application: Application): AndroidViewModel(application) {
    private val read_all_daily_user_metric_snapshot_data: LiveData<List<DAILY_USER_METRIC_SNAPSHOT>>
    private val daily_user_metric_snapshot_repository: DAILY_USER_METRIC_SNAPSHOT_REPO

    init {
        val dailyUserMetricSnapshotDao = EXERTION_DB.getDatabase(application).dailyUserMetricSnapshotDao()
        daily_user_metric_snapshot_repository = DAILY_USER_METRIC_SNAPSHOT_REPO(dailyUserMetricSnapshotDao)
        read_all_daily_user_metric_snapshot_data = daily_user_metric_snapshot_repository.read_all_daily_user_metric_snapshot_data
    }
}