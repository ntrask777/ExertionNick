package com.example.exertion.data.personal_analytics

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.exertion.data.EXERTION_DB
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PERSONAL_ANALYTICS_VM(application: Application): AndroidViewModel(application) {
    private val read_all_data_pa: LiveData<List<PERSONAL_ANALYTICS>>
    private val repository_pa: PERSONAL_ANALYTICS_REPO

    init {
        val personalAnalyticsDao = EXERTION_DB.getDatabase(application).personalAnalyticsDao()
        repository_pa = PERSONAL_ANALYTICS_REPO(personalAnalyticsDao)
        read_all_data_pa = repository_pa.read_all_data_pa
    }

    fun addPersonalAnalytics(personal_analytics: PERSONAL_ANALYTICS) {
        viewModelScope.launch(Dispatchers.IO) {
            repository_pa.addPersonalAnalytics(personal_analytics)
        }
    }
}