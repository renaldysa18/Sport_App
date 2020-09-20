package com.redveloper.sportapp.domain.repository

import com.redveloper.sportapp.domain.model.*
import com.redveloper.sportapp.vo.Resource
import kotlinx.coroutines.flow.Flow

interface RepositoryImpl {

    fun getAllCountries() : Flow<Resource<List<Country>>>
    fun getAllLeague(country: String): Flow<Resource<List<League>>>
    fun getAllTeamInLeague(league: String): Flow<Resource<List<Team>>>
    fun getDetailTeam(idTeam: String): Flow<Resource<Team>>
    fun getAllMatchInLeague(idLeague: String): Flow<Resource<List<Match>>>
    fun getAllClassementInLeague(
        idLeague: String,
        season: String
    ): Flow<Resource<List<Classement>>>

    fun setSelectedLeague(league : League)
    fun getSelectedLeague() : Flow<League>
    fun checkLeagueHasItem() : Flow<Boolean>

    fun getFavoriteTeam() : Flow<List<Team>>
    fun setFavoriteTeam(team : Team, state : Boolean)
}