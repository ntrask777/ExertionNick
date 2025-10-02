package com.example.exertion.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.exertion.data.daily_user_metric_snapshot.DAILY_USER_METRIC_SNAPSHOT_DAO
import com.example.exertion.data.exercise.EXERCISE_DAO
import com.example.exertion.data.exercise_metric_snapshot.EXERCISE_METRIC_SNAPSHOT_DAO
import com.example.exertion.data.personal_analytics.PERSONAL_ANALYTICS
import com.example.exertion.data.personal_analytics.PERSONAL_ANALYTICS_DAO
import com.example.exertion.data.rep_entry.REP_ENTRY_DAO
import com.example.exertion.data.set_entry.SET_ENTRY_DAO
import com.example.exertion.data.user_table.read_dao.UserReadDao
import com.example.exertion.data.user_table.UserTable
import com.example.exertion.data.user_table.write_dao.UserWriteDao
import com.example.exertion.data.workout.WORKOUT_DAO
import com.example.exertion.data.workout_exercise.WORKOUT_EXERCISE_DAO
import com.example.exertion.data.workout_metric_snapshot.WORKOUT_METRIC_SNAPSHOT_DAO

@Database(
    entities = [UserTable::class, PERSONAL_ANALYTICS::class],
    version = 1,
    exportSchema = true
)
@TypeConverters(CONVERTERS::class)
abstract class EXERTION_DB: RoomDatabase() {
    abstract fun userReadDao(): UserReadDao
    abstract fun userWriteDao(): UserWriteDao
    abstract fun personalAnalyticsDao(): PERSONAL_ANALYTICS_DAO
    abstract fun exerciseDao(): EXERCISE_DAO
    abstract fun workoutDao(): WORKOUT_DAO
    abstract fun workoutExerciseDao(): WORKOUT_EXERCISE_DAO
    abstract fun setEntryDao(): SET_ENTRY_DAO
    abstract fun repEntryDao(): REP_ENTRY_DAO
    abstract fun workoutMetricSnapshotDao(): WORKOUT_METRIC_SNAPSHOT_DAO
    abstract fun dailyUserMetricSnapshotDao(): DAILY_USER_METRIC_SNAPSHOT_DAO
    abstract fun exerciseMetricSnapshotDao(): EXERCISE_METRIC_SNAPSHOT_DAO

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