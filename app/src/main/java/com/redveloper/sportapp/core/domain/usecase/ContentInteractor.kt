package com.redveloper.sportapp.core.domain.usecase

import com.redveloper.sportapp.core.domain.model.*
import com.redveloper.sportapp.core.domain.repository.RepositoryImpl
import com.redveloper.sportapp.core.vo.Resource
import kotlinx.coroutines.flow.Flow

class ContentInteractor (private val repositoryImpl: RepositoryImpl) : ContentUseCase {

    override fun getAllTeamInLeague(league: String): Flow<Resource<List<Team>>> = repositoryImpl.getAllTeamInLeague(league)

    override fun getAllMatchInLeague(idLeague: String): Flow<Resource<List<Match>>> = repositoryImpl.getAllMatchInLeague(idLeague)

    override fun getAllClassementInLeague(
        idLeague: String,
        season: String
    ): Flow<Resource<List<Classement>>> = repositoryImpl.getAllClassementInLeague(idLeague, season)

    override fun getFavoriteTeam(): Flow<List<Team>> = repositoryImpl.getFavoriteTeam()
    override fun setFavoriteTeam(team: Team, state: Boolean) = repositoryImpl.setFavoriteTeam(team, state)

}