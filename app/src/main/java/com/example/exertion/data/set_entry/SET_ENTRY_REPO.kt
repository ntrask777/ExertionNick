package com.example.exertion.data.set_entry

import androidx.lifecycle.LiveData

class SET_ENTRY_REPO(private val setEntryDao: SET_ENTRY_DAO) {
    val read_all_set_entry_data: LiveData<List<SET_ENTRY>> = setEntryDao.readAllSetEntryData()

    suspend fun addSetEntry(setEntry: SET_ENTRY) {
        setEntryDao.addSetEntry(setEntry)
    }
}