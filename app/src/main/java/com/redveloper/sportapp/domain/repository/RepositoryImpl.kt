package com.redveloper.sportapp.domain.repository

import androidx.lifecycle.LiveData
import com.redveloper.sportapp.domain.model.*
import com.redveloper.sportapp.vo.Resource

interface RepositoryImpl {

    fun getAllCountries() : LiveData<Resource<List<Country>>>
    fun getAllLeague(country: String): LiveData<Resource<List<League>>>
    fun getAllTeamInLeague(league: String): LiveData<Resource<List<Team>>>
    fun getDetailTeam(idTeam: String): LiveData<Resource<Team>>
    fun getAllMatchInLeague(idLeague: String): LiveData<Resource<List<Match>>>
    fun getAllClassementInLeague(
        idLeague: String,
        season: String
    ): LiveData<Resource<List<Classement>>>
}