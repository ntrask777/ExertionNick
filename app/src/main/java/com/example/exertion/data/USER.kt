package com.example.exertion.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "USER",
    indices = [Index(value = ["email"], unique = true)] // enforce email uniqueness
)
data class USER(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "user_id")
    val user_id: Int = 0, // needs to be primary key and also auto increment

    @ColumnInfo(name = "username")
    val username: String?, // nullable

    @ColumnInfo(name = "email")
    val email: String,

    @ColumnInfo(name = "password_hash")
    val password_hash: String?, // nullable

    @ColumnInfo(name = "created_at")
    val created_at: Long
)