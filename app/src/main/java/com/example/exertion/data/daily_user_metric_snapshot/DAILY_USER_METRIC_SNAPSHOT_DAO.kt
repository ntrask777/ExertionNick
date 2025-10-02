package com.example.exertion.data.daily_user_metric_snapshot

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface DAILY_USER_METRIC_SNAPSHOT_DAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addDailyUserMetricSnapshot(dailyUserMetricSnapshot: DAILY_USER_METRIC_SNAPSHOT)

    @Query(
        "SELECT * FROM DAILY_USER_METRIC_SNAPSHOT ORDER BY snapshot_id ASC"
    )
    fun readAllDailyUserMetricSnapshotData(): LiveData<List<DAILY_USER_METRIC_SNAPSHOT>>
}