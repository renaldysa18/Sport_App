package com.redveloper.sportapp.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.redveloper.sportapp.data.source.local.LocalDataSource
import com.redveloper.sportapp.data.source.remote.ApiResponse
import com.redveloper.sportapp.data.source.remote.LoadLeagueCallback
import com.redveloper.sportapp.data.source.remote.RemoteDataSource
import com.redveloper.sportapp.data.source.remote.StatusResponse
import com.redveloper.sportapp.data.source.remote.response.classement.ClassementResponse
import com.redveloper.sportapp.data.source.remote.response.country.CountryResponse
import com.redveloper.sportapp.data.source.remote.response.league.LeagueResponse
import com.redveloper.sportapp.data.source.remote.response.match.MatchResponse
import com.redveloper.sportapp.data.source.remote.response.team.TeamResponse
import com.redveloper.sportapp.domain.model.*
import com.redveloper.sportapp.domain.repository.RepositoryImpl
import com.redveloper.sportapp.utils.AppExecutors
import com.redveloper.sportapp.utils.datamapper.DataMapperDomainToEntity
import com.redveloper.sportapp.utils.datamapper.DataMapperEntityToDomain
import com.redveloper.sportapp.utils.datamapper.DataMapperResponseToEntity
import com.redveloper.sportapp.utils.datamapper.DataMapperResponsetoDomain
import com.redveloper.sportapp.vo.Resource


class Repository private constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSouce : LocalDataSource,
    private val appExecutors: AppExecutors
) : RepositoryImpl{

    companion object{
        @Volatile
        private var instance : Repository? = null

        fun getInstance(remoteDataSource: RemoteDataSource, localDataSouce: LocalDataSource, appExecutors: AppExecutors) : Repository =
            instance ?: synchronized(this){
                instance ?: Repository(remoteDataSource, localDataSouce, appExecutors)
            }
    }

    override fun getAllCountries(): LiveData<Resource<List<Country>>> {
        return object : NetworkBoundResource<List<Country>, List<CountryResponse>>(appExecutors){
            override fun loadFromDB(): LiveData<List<Country>> {
                return Transformations.map(localDataSouce.getAllCountry()){
                    DataMapperEntityToDomain.mapCountryEntityToDomain(it)
                }
            }

            override fun shouldFetch(data: List<Country>?): Boolean {
                return data == null || data.isEmpty()
            }

            override fun createCall(): LiveData<ApiResponse<List<CountryResponse>>> {
                return remoteDataSource.getAllCountries()
            }

            override fun saveCallResult(data: List<CountryResponse>) {
                val countryList = DataMapperResponseToEntity.mapResponseToCountryEntity(data)
                localDataSouce.insertCountry(countryList)
            }
        }.asLiveData()
    }

    override fun getAllLeague(country: String): LiveData<Resource<List<League>>> {
        val result = MutableLiveData<Resource<List<League>>>()
        remoteDataSource.getAllLeague(country, object : LoadLeagueCallback{
            override fun onResult(data: ApiResponse<List<LeagueResponse>>) {
                when(data.status){
                    StatusResponse.SUCCESS -> {
                        if (!data.body.isNullOrEmpty()){
                            val item = DataMapperResponsetoDomain.mapLeagueResponseToDomain(data.body)
                            if (!item.isNullOrEmpty()){
                                result.value = Resource.Succes(item)
                            }
                        }
                    }
                    StatusResponse.ERROR -> {
                        if (data.message != null){
                            result.value = Resource.Error(message = data.message)
                        }
                    }
                    StatusResponse.EMPTY -> {
                        result.value = Resource.Loading()
                    }
                }
            }
        })
        return result
    }

    override fun getAllTeamInLeague(league: String): LiveData<Resource<List<Team>>> {
        return object : NetworkBoundResource<List<Team>, List<TeamResponse>>(appExecutors){
            override fun loadFromDB(): LiveData<List<Team>> {
                return Transformations.map(localDataSouce.getAllTeam()){
                    DataMapperEntityToDomain.mapTeamEntityToDomain(it)
                }
            }

            override fun shouldFetch(data: List<Team>?): Boolean {
                return data == null || data.isEmpty()
            }

            override fun createCall(): LiveData<ApiResponse<List<TeamResponse>>> {
                return remoteDataSource.getAllTeamInLeague(league)
            }

            override fun saveCallResult(data: List<TeamResponse>) {
                val dataList = DataMapperResponseToEntity.mapResponseToTeamEntity(data)
                localDataSouce.insertAllTeam(dataList)
            }
        }.asLiveData()
    }

    override fun getDetailTeam(idTeam: String): LiveData<Resource<Team>> {
        return object : NetworkBoundResource<Team, TeamResponse>(appExecutors){
            override fun loadFromDB(): LiveData<Team> {
                return Transformations.map(localDataSouce.getDetailTeam(idTeam)){
                    DataMapperEntityToDomain.mapDetalTeamEntityToDomain(it)
                }
            }

            override fun shouldFetch(data: Team?): Boolean {
                return data == null
            }

            override fun createCall(): LiveData<ApiResponse<TeamResponse>> {
                return remoteDataSource.getDetailTeam(idTeam)
            }

            override fun saveCallResult(data: TeamResponse) {
                val teamEntity = DataMapperResponseToEntity.mapResponseToDetailTeamEntity(data)
                localDataSouce.updateTeam(teamEntity)
            }
        }.asLiveData()
    }

    override fun getAllMatchInLeague(idLeague: String): LiveData<Resource<List<Match>>> {
        return object : NetworkBoundResource<List<Match>, List<MatchResponse>>(appExecutors){
            override fun loadFromDB(): LiveData<List<Match>> {
                return Transformations.map(localDataSouce.getAllMatch()){
                    DataMapperEntityToDomain.mapMatchEntityToDomain(it)
                }
            }

            override fun shouldFetch(data: List<Match>?): Boolean {
                return data == null || data.isEmpty()
            }

            override fun createCall(): LiveData<ApiResponse<List<MatchResponse>>> {
                return remoteDataSource.getAllMatchInLeague(idLeague)
            }

            override fun saveCallResult(data: List<MatchResponse>) {
                val dataList = DataMapperResponseToEntity.mapResponseToMatchEntity(data)
                localDataSouce.insertMatch(dataList)
            }
        }.asLiveData()
    }

    override fun getAllClassementInLeague(
        idLeague: String,
        season: String
    ): LiveData<Resource<List<Classement>>> {
        return object : NetworkBoundResource<List<Classement>, List<ClassementResponse>>(appExecutors){
            override fun loadFromDB(): LiveData<List<Classement>> {
                return Transformations.map(localDataSouce.getAllClassement()){
                    DataMapperEntityToDomain.mapClassementEntityToDomain(it)
                }
            }

            override fun shouldFetch(data: List<Classement>?): Boolean {
                return data == null || data.isEmpty()
            }

            override fun createCall(): LiveData<ApiResponse<List<ClassementResponse>>> {
                return remoteDataSource.getAllClasementInLeague(idLeague, season)
            }

            override fun saveCallResult(data: List<ClassementResponse>) {
                val dataList = DataMapperResponseToEntity.mapResponseToClassementEntity(data)
                localDataSouce.insertClassement(dataList)
            }
        }.asLiveData()
    }

    override fun setSelectedLeague(league: League) {
        val leagueEntity = DataMapperDomainToEntity.mapLeaguDomainToEntity(league)
        appExecutors.diskIO().execute { localDataSouce.insertLeague(leagueEntity) }
    }

    override fun getSelectedLeague(): LiveData<League> {
        return Transformations.map(localDataSouce.getSelectedLeague()){
            DataMapperEntityToDomain.mapLeagueEntityToDomain(it)
        }
    }

    override fun checkLeagueHasItem(): LiveData<Boolean> {
        return localDataSouce.leagueHasItem()
    }
}