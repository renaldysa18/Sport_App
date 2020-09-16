package com.redveloper.sportapp.data.source.local.room.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.redveloper.sportapp.data.source.local.entity.LeagueEntity

@Dao
abstract class LeagueDao : BaseDao<LeagueEntity> {

    @Query("SELECT * FROM leagueentity")
    abstract fun getAllLeague() : LiveData<List<LeagueEntity>>
}