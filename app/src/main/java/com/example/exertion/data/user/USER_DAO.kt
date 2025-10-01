package com.example.exertion.data.user

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface USER_DAO {

    // Cannot have two identical users
    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun addUser(user: USER)

    // List of users in ascending order by id
    @Query(
        "SELECT * FROM USER ORDER BY user_id ASC"
    )
    fun readAllData(): LiveData<List<USER>>
}