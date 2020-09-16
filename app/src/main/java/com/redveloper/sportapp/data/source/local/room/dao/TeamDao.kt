package com.redveloper.sportapp.data.source.local.room.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.redveloper.sportapp.data.source.local.entity.TeamEntity

@Dao
abstract class TeamDao : BaseDao<TeamEntity> {
    @Query("SELECT * FROM teamentity")
    abstract fun getAllTeam() : LiveData<List<TeamEntity>>

    @Query("SELECT * FROM teamentity WHERE id = :id")
    abstract fun getDetailTeam(id: String) : LiveData<TeamEntity>
}