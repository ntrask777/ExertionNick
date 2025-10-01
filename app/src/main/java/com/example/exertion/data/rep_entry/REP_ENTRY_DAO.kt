package com.example.exertion.data.rep_entry

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface REP_ENTRY_DAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addRepEntry(repEntry: REP_ENTRY)

    @Query(
        "SELECT * FROM REP_ENTRY ORDER BY rep_id ASC"
    )
    fun readAllRepEntryData(): LiveData<List<REP_ENTRY>>
}