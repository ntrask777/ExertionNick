package com.example.exertion.data.personal_analytics

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface PERSONAL_ANALYTICS_DAO {
    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun addPersonalAnalytics(personal_analytics: PERSONAL_ANALYTICS)

    @Query(
        "SELECT * FROM PERSONAL_ANALYTICS ORDER BY entry_id ASC"
    )
    fun readAllDataPA(): LiveData<List<PERSONAL_ANALYTICS>>
}