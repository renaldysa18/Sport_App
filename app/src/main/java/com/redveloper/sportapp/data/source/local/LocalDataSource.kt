package com.redveloper.sportapp.data.source.local

import androidx.lifecycle.LiveData
import com.redveloper.sportapp.data.source.local.entity.*
import com.redveloper.sportapp.data.source.local.room.dao.*

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
    fun getAllCountry() : LiveData<List<CountryEntity>> = countryDao.getAllCountry()
    fun insertCountry(data : List<CountryEntity>) = countryDao.insert(data)

    //classement
    fun getAllClassement() : LiveData<List<ClassementEntity>> = classementDao.getAllClassement()
    fun insertClassement(data : List<ClassementEntity>) = classementDao.insert(data)

    //team
    fun getAllTeam() : LiveData<List<TeamEntity>> = teamDao.getAllTeam()
    fun getDetailTeam(idTeam : String) : LiveData<TeamEntity> = teamDao.getDetailTeam(idTeam)
    fun insertAllTeam(data : List<TeamEntity>) = teamDao.insert(data)
    fun setFavoriteTeam(data : TeamEntity, state : Boolean) {
        data.isFavorite = state
        teamDao.update(data)
    }
    fun getFavoriteTeam() : LiveData<List<TeamEntity>> = teamDao.getFavoriteTeam()

    //league
    fun getSelectedLeague() : LiveData<LeagueEntity> = leagueDao.getSelectedLeague()
    fun insertLeague(data : LeagueEntity) = leagueDao.insert(data)
    fun leagueHasItem() :LiveData<Boolean> = leagueDao.checkItemLeague()

    //match
    fun getAllMatch() : LiveData<List<MatchEntity>> = matchDao.getAllMatch()
    fun insertMatch(data : List<MatchEntity>) = matchDao.insert(data)


}