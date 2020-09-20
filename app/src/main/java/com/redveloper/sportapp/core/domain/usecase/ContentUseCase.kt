package com.redveloper.sportapp.core.domain.usecase

import com.redveloper.sportapp.core.domain.model.*
import com.redveloper.sportapp.core.vo.Resource
import kotlinx.coroutines.flow.Flow

interface ContentUseCase {

    fun getAllTeamInLeague(league: String): Flow<Resource<List<Team>>>
    fun getAllMatchInLeague(idLeague: String): Flow<Resource<List<Match>>>
    fun getAllClassementInLeague(
        idLeague: String,
        season: String
    ): Flow<Resource<List<Classement>>>

    fun getFavoriteTeam(): Flow<List<Team>>
    fun setFavoriteTeam(team: Team, state: Boolean)

}