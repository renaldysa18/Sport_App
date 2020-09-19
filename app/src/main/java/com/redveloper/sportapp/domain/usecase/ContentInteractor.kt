package com.redveloper.sportapp.domain.usecase

import androidx.lifecycle.LiveData
import com.redveloper.sportapp.domain.model.*
import com.redveloper.sportapp.domain.repository.RepositoryImpl
import com.redveloper.sportapp.vo.Resource

class ContentInteractor (private val repositoryImpl: RepositoryImpl) : ContentUseCase {
    override fun getAllCountries(): LiveData<Resource<List<Country>>> = repositoryImpl.getAllCountries()

    override fun getAllLeague(country: String): LiveData<Resource<List<League>>> = repositoryImpl.getAllLeague(country)

    override fun getAllTeamInLeague(league: String): LiveData<Resource<List<Team>>> = repositoryImpl.getAllTeamInLeague(league)

    override fun getDetailTeam(idTeam: String): LiveData<Resource<Team>> = repositoryImpl.getDetailTeam(idTeam)

    override fun getAllMatchInLeague(idLeague: String): LiveData<Resource<List<Match>>> = repositoryImpl.getAllMatchInLeague(idLeague)

    override fun getAllClassementInLeague(
        idLeague: String,
        season: String
    ): LiveData<Resource<List<Classement>>> = repositoryImpl.getAllClassementInLeague(idLeague, season)

    override fun setSelectedLeaegue(league: League) = repositoryImpl.setSelectedLeague(league)
    override fun getSelectedLeague(): LiveData<League> = repositoryImpl.getSelectedLeague()
    override fun checkLeagueHasItem(): LiveData<Boolean> = repositoryImpl.checkLeagueHasItem()
}