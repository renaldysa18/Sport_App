package com.redveloper.sportapp.data.source.local.room.dao

import androidx.room.Dao
import androidx.room.Query
import com.redveloper.sportapp.data.source.local.entity.TeamEntity
import kotlinx.coroutines.flow.Flow

@Dao
abstract class TeamDao : BaseDao<TeamEntity> {
    @Query("SELECT * FROM teamentity")
    abstract fun getAllTeam(): Flow<List<TeamEntity>>

    @Query("SELECT * FROM teamentity WHERE id = :id")
    abstract fun getDetailTeam(id: String): Flow<TeamEntity>

    @Query("SELECT * FROM teamentity WHERE isFavorite = 1")
    abstract fun getFavoriteTeam(): Flow<List<TeamEntity>>

}