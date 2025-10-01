package com.example.exertion.data.user

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.exertion.data.EXERTION_DB
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class USER_VM(application: Application): AndroidViewModel(application) {
    private val read_all_data: LiveData<List<USER>>
    private val repository: USER_REPO

    init {
        val userDao = EXERTION_DB.getDatabase(application).userDao()
        repository = USER_REPO(userDao)
        read_all_data = repository.read_all_data
    }

    fun addUser(user: USER) {
        // run on background thread
        viewModelScope.launch(Dispatchers.IO) {
            repository.addUser(user)
        }
    }
}