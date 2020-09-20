package com.redveloper.sportapp.data.source.local

import com.redveloper.sportapp.data.source.local.entity.*
import com.redveloper.sportapp.data.source.local.room.dao.*
import kotlinx.coroutines.flow.Flow

class LocalDataSource private constructor(
    private val classementDao : ClassementDao,
    private val countryDao : CountryDao,
    private val leagueDao : LeagueDao,
    private val matchDao : MatchDao,
    private val teamDao: TeamDao
) {

    companion object{
        private var instance : LocalDataSource? = null

        fun getInstance(
            classementDao: ClassementDao, countryDao: CountryDao, leagueDao: LeagueDao,
            matchDao: MatchDao, teamDao: TeamDao
        ) : LocalDataSource = instance ?: LocalDataSource(classementDao, countryDao, leagueDao, matchDao, teamDao)
    }

    //country
    fun getAllCountry() : Flow<List<CountryEntity>> = countryDao.getAllCountry()
    suspend fun insertCountry(data : List<CountryEntity>) = countryDao.insert(data)

    //classement
    fun getAllClassement() : Flow<List<ClassementEntity>> = classementDao.getAllClassement()
    suspend fun insertClassement(data : List<ClassementEntity>) = classementDao.insert(data)

    //team
    fun getAllTeam() : Flow<List<TeamEntity>> = teamDao.getAllTeam()
    suspend fun insertAllTeam(data : List<TeamEntity>) = teamDao.insert(data)
    fun setFavoriteTeam(data : TeamEntity, state : Boolean) {
        data.isFavorite = state
        teamDao.update(data)
    }
    fun getFavoriteTeam() : Flow<List<TeamEntity>> = teamDao.getFavoriteTeam()

    //league
    fun getAllLeague() : Flow<List<LeagueEntity>> = leagueDao.getAllLeague()
    suspend fun insertLeague(data : List<LeagueEntity>) = leagueDao.insert(data)


    //match
    fun getAllMatch() : Flow<List<MatchEntity>> = matchDao.getAllMatch()
    suspend fun insertMatch(data : List<MatchEntity>) = matchDao.insert(data)


}