package com.example.exertion.data.user_table

import com.example.exertion.data.user_table.write_dao.UserWriteDao
import com.example.exertion.data.user_table.read_dao.UserReadDao
import kotlinx.coroutines.flow.Flow

class UserRepo(
    private val userReadDao: UserReadDao,
    private val userWriteDao: UserWriteDao
) {
    // READS
    fun readAllData(): Flow<List<UserTable>> = userReadDao.readAllData()

    fun observeUser(id: Int): Flow<UserTable?> =
        userReadDao.observeUser(id)
    suspend fun upsertUser(user: UserTable) {
        userWriteDao.upsertUser(user)
    }
}