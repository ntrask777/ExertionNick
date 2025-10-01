package com.example.exertion.data.user

import androidx.lifecycle.LiveData

class USER_REPO(private val userDao: USER_DAO) {
    val read_all_data: LiveData<List<USER>> = userDao.readAllData()

    suspend fun addUser(user: USER) {
        userDao.addUser(user)
    }
}