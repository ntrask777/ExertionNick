package com.example.exertion.data.exercise

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import com.example.exertion.data.user.USER

@Entity(
    tableName = "EXERCISE",
    foreignKeys = [
        ForeignKey(
            entity = USER::class,
            parentColumns = ["user_id"],
            childColumns = ["user_id"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [
        Index(value = ["name"]),
        Index(value = ["user_id", "name"], unique = true) // per-user unique names (case-insensitive via collate)
    ]
)
data class EXERCISE(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "exercise_id")
    val exercise_id: Int = 0,

    @ColumnInfo(name = "name", collate = ColumnInfo.NOCASE)
    val name: String,

    @ColumnInfo(name = "muscle_group")
    val muscle_group: String, // maybe add hash table or enum class similar to gender

    @ColumnInfo(name = "equipment")
    val equipment: String?,

    @ColumnInfo(name = "is_unilateral")
    val is_unilateral: Boolean = false,

    @ColumnInfo(name = "is_custom")
    val is_custom: Boolean = false,

    @ColumnInfo(name = "user_id")
    val user_id: Int?,

    @ColumnInfo(name = "notes")
    val notes: String?
)