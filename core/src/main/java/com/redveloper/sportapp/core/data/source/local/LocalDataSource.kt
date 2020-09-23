package com.redveloper.sportapp.core.data.source.local

import android.util.Log
import com.redveloper.sportapp.core.data.source.local.entity.*
import com.redveloper.sportapp.core.data.source.local.room.dao.*
import kotlinx.coroutines.flow.Flow

class LocalDataSource(
    private val classementDao: ClassementDao,
    private val matchDao: MatchDao,
    private val teamDao: TeamDao
) {

    //classement
    fun getAllClassement(): Flow<List<ClassementEntity>> = classementDao.getAllClassement()
    suspend fun insertClassement(data: List<ClassementEntity>) = classementDao.insert(data)

    //team
    fun getAllTeam(): Flow<List<TeamEntity>> = teamDao.getAllTeam()
    suspend fun insertAllTeam(data: List<TeamEntity>) = teamDao.insert(data)
    fun setFavoriteTeam(data: TeamEntity, state: Boolean) {
        data.isFavorite = state
        Log.i("dataUpdate", data.toString())
        teamDao.update(data)
    }

    fun getFavoriteTeam(): Flow<List<TeamEntity>> = teamDao.getFavoriteTeam()

    //match
    fun getAllMatch(): Flow<List<MatchEntity>> = matchDao.getAllMatch()
    suspend fun insertMatch(data: List<MatchEntity>) = matchDao.insert(data)


}