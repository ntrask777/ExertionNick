package com.example.exertion.data.daily_user_metric_snapshot

import androidx.lifecycle.LiveData

class DAILY_USER_METRIC_SNAPSHOT_REPO(private val dailyUserMetricSnapshotDao: DAILY_USER_METRIC_SNAPSHOT_DAO) {
    val read_all_daily_user_metric_snapshot_data: LiveData<List<DAILY_USER_METRIC_SNAPSHOT>> = dailyUserMetricSnapshotDao.readAllDailyUserMetricSnapshotData()

    suspend fun addDailyUserMetricSnapshot(dailyUserMetricSnapshot: DAILY_USER_METRIC_SNAPSHOT) {
        dailyUserMetricSnapshotDao.addDailyUserMetricSnapshot(dailyUserMetricSnapshot)
    }
}