package com.example.exertion.data.rep_entry

import androidx.lifecycle.LiveData

class REP_ENTRY_REPO(private val repEntryDao: REP_ENTRY_DAO) {
    val read_all_rep_entry_data: LiveData<List<REP_ENTRY>> = repEntryDao.readAllRepEntryData()

    suspend fun addRepEntry(repEntry: REP_ENTRY) {
        repEntryDao.addRepEntry(repEntry)
    }
}