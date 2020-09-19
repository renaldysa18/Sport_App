package com.redveloper.sportapp.data.source.local.room.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.redveloper.sportapp.data.source.local.entity.LeagueEntity

@Dao
abstract class LeagueDao : BaseDao<LeagueEntity> {

    @Query("SELECT * FROM leagueentity WHERE id = :id LIMIT 1")
    abstract fun getSelectedLeague(id: Int = 0) : LiveData<LeagueEntity>
}