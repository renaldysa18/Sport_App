package com.redveloper.sportapp.data.source.local.room.dao

import androidx.room.Dao
import androidx.room.Query
import com.redveloper.sportapp.data.source.local.entity.LeagueEntity
import kotlinx.coroutines.flow.Flow

@Dao
abstract class LeagueDao : BaseDao<LeagueEntity> {

    @Query("SELECT * FROM leagueentity WHERE id = :id LIMIT 1")
    abstract fun getSelectedLeague(id: Int = 0): Flow<LeagueEntity>

    @Query("SELECT EXISTS(SELECT * FROM leagueentity)")
    abstract fun checkItemLeague(): Flow<Boolean>
}