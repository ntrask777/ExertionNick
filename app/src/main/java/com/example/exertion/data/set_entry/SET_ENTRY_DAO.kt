package com.example.exertion.data.set_entry

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface SET_ENTRY_DAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addSetEntry(setEntry: SET_ENTRY)

    @Query(
        "SELECT * FROM SET_ENTRY ORDER BY set_id ASC"
    )
    fun readAllSetEntryData(): LiveData<List<SET_ENTRY>>
}