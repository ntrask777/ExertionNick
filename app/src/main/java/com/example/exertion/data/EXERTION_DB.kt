package com.example.exertion.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.exertion.data.user.USER
import com.example.exertion.data.user.USER_DAO

@Database(
    entities = [USER::class],
    version = 1,
    exportSchema = false
)
abstract class EXERTION_DB: RoomDatabase() {
    abstract fun userDao(): USER_DAO

    companion object {
        // writes are visible to other threads
        @Volatile
        private var INSTANCE: EXERTION_DB? = null // singleton class

        fun getDatabase(context: Context): EXERTION_DB {
            val temp_instance = INSTANCE
            if (temp_instance != null) {
                return temp_instance
            }
            // protected from concurrent execution by multiple threads
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    EXERTION_DB::class.java,
                    "exertion_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}