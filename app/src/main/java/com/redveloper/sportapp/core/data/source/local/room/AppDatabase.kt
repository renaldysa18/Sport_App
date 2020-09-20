package com.redveloper.sportapp.core.data.source.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.redveloper.sportapp.core.data.source.local.entity.*
import com.redveloper.sportapp.core.data.source.local.room.dao.*

@Database(
    entities = [ClassementEntity::class, MatchEntity::class, TeamEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun ClassementDao() : ClassementDao
    abstract fun MatchDao() : MatchDao
    abstract fun TeamDao() : TeamDao

    companion object{
        @Volatile
        private var instance : AppDatabase? = null

        fun getInstance(context: Context) : AppDatabase {
            instance ?: synchronized(this){
                instance = instance ?: Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, "content.db").build()
            }
            return instance as AppDatabase
        }
    }

}