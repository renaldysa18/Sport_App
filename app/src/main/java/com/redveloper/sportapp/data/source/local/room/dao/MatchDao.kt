package com.redveloper.sportapp.data.source.local.room.dao

import androidx.room.Dao
import androidx.room.Query
import com.redveloper.sportapp.data.source.local.entity.MatchEntity
import kotlinx.coroutines.flow.Flow

@Dao
abstract class MatchDao : BaseDao<MatchEntity> {

    @Query("SELECT * FROM matchentity")
    abstract fun getAllMatch(): Flow<List<MatchEntity>>
}