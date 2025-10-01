package com.example.exertion.data.set_entry

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.exertion.data.EXERTION_DB
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SET_ENTRY_VM(application: Application): AndroidViewModel(application) {
    private val read_all_set_entry_data: LiveData<List<SET_ENTRY>>
    private val set_entry_repository: SET_ENTRY_REPO

    init {
        val setEntryDao = EXERTION_DB.getDatabase(application).setEntryDao()
        set_entry_repository = SET_ENTRY_REPO(setEntryDao)
        read_all_set_entry_data = set_entry_repository.read_all_set_entry_data
    }

    fun addSetEntry(setEntry: SET_ENTRY) {
        viewModelScope.launch(Dispatchers.IO) {
            set_entry_repository.addSetEntry(setEntry)
        }
    }
}