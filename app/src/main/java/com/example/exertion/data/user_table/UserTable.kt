package com.example.exertion.data.user_table

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "user_table",
    // enforce email + username uniqueness
    indices = [
        Index(value = ["email"], unique = true),
        Index(value = ["username"], unique = true)
    ]
)
data class UserTable(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "user_id")
    val user_id: Int = 0, // needs to be primary key and also auto increment

    @ColumnInfo(name = "username", collate = ColumnInfo.NOCASE)
    val username: String?, // nullable

    @ColumnInfo(name = "email", collate = ColumnInfo.NOCASE)
    val email: String,

    @ColumnInfo(name = "password_hash")
    val password_hash: String?, // nullable

    @ColumnInfo(name = "created_at")
    val created_at: Long
)