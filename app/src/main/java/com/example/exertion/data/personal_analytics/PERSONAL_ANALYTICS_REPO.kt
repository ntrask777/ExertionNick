package com.example.exertion.data.personal_analytics

import androidx.lifecycle.LiveData

class PERSONAL_ANALYTICS_REPO(private val personalAnalyticsDao: PERSONAL_ANALYTICS_DAO) {
    val read_all_data_pa: LiveData<List<PERSONAL_ANALYTICS>> = personalAnalyticsDao.readAllDataPA()

    suspend fun addPersonalAnalytics(personal_analytics: PERSONAL_ANALYTICS) {
        personalAnalyticsDao.addPersonalAnalytics(personal_analytics)
    }
}