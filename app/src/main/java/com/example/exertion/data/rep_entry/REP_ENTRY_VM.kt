package com.example.exertion.data.rep_entry

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.exertion.data.EXERTION_DB
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class REP_ENTRY_VM(application: Application): AndroidViewModel(application) {
    private val read_all_rep_entry_data: LiveData<List<REP_ENTRY>>
    private val rep_entry_repository: REP_ENTRY_REPO

    init {
        val repEntryDao = EXERTION_DB.getDatabase(application).repEntryDao()
        rep_entry_repository = REP_ENTRY_REPO(repEntryDao)
        read_all_rep_entry_data = rep_entry_repository.read_all_rep_entry_data
    }

    fun addRepEntry(repEntry: REP_ENTRY) {
        viewModelScope.launch(Dispatchers.IO) {
            rep_entry_repository.addRepEntry(repEntry)
        }
    }
}