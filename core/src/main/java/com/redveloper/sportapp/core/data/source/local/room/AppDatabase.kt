package com.redveloper.sportapp.core.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.redveloper.sportapp.core.data.source.local.entity.ClassementEntity
import com.redveloper.sportapp.core.data.source.local.entity.MatchEntity
import com.redveloper.sportapp.core.data.source.local.entity.TeamEntity
import com.redveloper.sportapp.core.data.source.local.room.dao.ClassementDao
import com.redveloper.sportapp.core.data.source.local.room.dao.MatchDao
import com.redveloper.sportapp.core.data.source.local.room.dao.TeamDao

@Database(
    entities = [ClassementEntity::class, MatchEntity::class, TeamEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun ClassementDao(): ClassementDao
    abstract fun MatchDao(): MatchDao
    abstract fun TeamDao(): TeamDao


}