package com.example.exertion.data.user_table.write_dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.example.exertion.data.user_table.UserTable

@Dao
interface UserWriteDao {
    // Try insert first, if row with same pk (in this case user_id) already exist, this runs update
    @Upsert
    suspend fun upsertUser(userTable: UserTable): Long

    @Query(
        "UPDATE user_table SET email = :email WHERE user_id = :id"
    )
    suspend fun updateUserEmail(id: Int, email: String): Int

    @Query(
        "UPDATE user_table SET username = :username WHERE user_id = :id"
    )
    suspend fun updateUsername(id: Int, username: String?): Int

    // cascade so no need for individual deletes
    @Query(
        "DELETE FROM user_table WHERE user_id = :id"
    )
    suspend fun deleteUser(id: Int): Int
}