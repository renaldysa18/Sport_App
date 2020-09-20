package com.redveloper.sportapp.domain.usecase

import com.redveloper.sportapp.domain.model.*
import com.redveloper.sportapp.vo.Resource
import kotlinx.coroutines.flow.Flow

interface ContentUseCase {

    fun getAllCountries(): Flow<Resource<List<Country>>>
    fun getAllLeague(country: String): Flow<Resource<List<League>>>
    fun getAllTeamInLeague(league: String): Flow<Resource<List<Team>>>
    fun getAllMatchInLeague(idLeague: String): Flow<Resource<List<Match>>>
    fun getAllClassementInLeague(
        idLeague: String,
        season: String
    ): Flow<Resource<List<Classement>>>

    fun getFavoriteTeam(): Flow<List<Team>>
    fun setFavoriteTeam(team: Team, state: Boolean)

    fun setSelectedLeague(league: League, state: Boolean)
}