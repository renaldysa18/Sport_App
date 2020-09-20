package com.redveloper.sportapp.data.source.local.room.dao

import androidx.room.Dao
import androidx.room.Query
import com.redveloper.sportapp.data.source.local.entity.LeagueEntity
import kotlinx.coroutines.flow.Flow

@Dao
abstract class LeagueDao : BaseDao<LeagueEntity> {

    @Query("SELECT * FROM leagueentity")
    abstract fun getAllLeague(): Flow<List<LeagueEntity>>

    @Query("DELETE FROM leagueentity")
    abstract suspend fun deleteOldLeague()
}