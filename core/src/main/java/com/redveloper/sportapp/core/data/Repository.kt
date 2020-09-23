package com.redveloper.sportapp.core.data

import android.util.Log
import com.redveloper.sportapp.core.data.source.local.LocalDataSource
import com.redveloper.sportapp.core.data.source.remote.ApiResponse
import com.redveloper.sportapp.core.data.source.remote.RemoteDataSource
import com.redveloper.sportapp.core.data.source.remote.response.classement.ClassementResponse
import com.redveloper.sportapp.core.data.source.remote.response.match.MatchResponse
import com.redveloper.sportapp.core.data.source.remote.response.team.TeamResponse
import com.redveloper.sportapp.core.domain.model.*
import com.redveloper.sportapp.core.domain.repository.RepositoryImpl
import com.redveloper.sportapp.core.utils.AppExecutors
import com.redveloper.sportapp.core.utils.datamapper.DataMapperDomainToEntity
import com.redveloper.sportapp.core.utils.datamapper.DataMapperEntityToDomain
import com.redveloper.sportapp.core.utils.datamapper.DataMapperResponseToEntity
import com.redveloper.sportapp.core.vo.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


class Repository (
    private val remoteDataSource: RemoteDataSource,
    private val localDataSouce: LocalDataSource,
    private val appExecutors: AppExecutors
) : RepositoryImpl {


    override fun getAllMatchInLeague(idLeague: String): Flow<Resource<List<Match>>> {
        return object : NetworkBoundResource<List<Match>, List<MatchResponse>>(appExecutors) {
            override fun loadFromDB(): Flow<List<Match>> {
                return localDataSouce.getAllMatch()
                    .map { DataMapperEntityToDomain.mapMatchEntityToDomain(it) }
            }

            override fun shouldFetch(data: List<Match>?): Boolean {
                return true
            }

            override suspend fun createCall(): Flow<ApiResponse<List<MatchResponse>>> {
                return remoteDataSource.getAllMatchInLeague(idLeague)
            }

            override suspend fun saveCallResult(data: List<MatchResponse>) {
                val matchEntity = DataMapperResponseToEntity.mapResponseToMatchEntity(data)
                localDataSouce.insertMatch(matchEntity)
            }
        }.asFlow()
    }

    override fun getAllClassementInLeague(
        idLeague: String,
        season: String
    ): Flow<Resource<List<Classement>>> {
        return object :
            NetworkBoundResource<List<Classement>, List<ClassementResponse>>(appExecutors) {
            override fun loadFromDB(): Flow<List<Classement>> {
                return localDataSouce.getAllClassement()
                    .map { DataMapperEntityToDomain.mapClassementEntityToDomain(it) }
            }

            override fun shouldFetch(data: List<Classement>?): Boolean {
                return true
            }

            override suspend fun createCall(): Flow<ApiResponse<List<ClassementResponse>>> {
                return remoteDataSource.getAllClasementInLeague(idLeague, season)
            }

            override suspend fun saveCallResult(data: List<ClassementResponse>) {
                val classementEntity =
                    DataMapperResponseToEntity.mapResponseToClassementEntity(data)
                localDataSouce.insertClassement(classementEntity)
            }
        }.asFlow()
    }

    override fun getAllTeamInLeague(league: String): Flow<Resource<List<Team>>> {
        return object : NetworkBoundResource<List<Team>, List<TeamResponse>>(appExecutors) {
            override fun loadFromDB(): Flow<List<Team>> {
                return localDataSouce.getAllTeam()
                    .map { DataMapperEntityToDomain.mapTeamEntityToDomain(it) }
            }

            override fun shouldFetch(data: List<Team>?): Boolean {
                return data == null || data.isEmpty()
            }

            override suspend fun createCall(): Flow<ApiResponse<List<TeamResponse>>> {
                return remoteDataSource.getAllTeamInLeague(league)
            }

            override suspend fun saveCallResult(data: List<TeamResponse>) {
                val teamEntity = DataMapperResponseToEntity.mapResponseToTeamEntity(data)
                localDataSouce.insertAllTeam(teamEntity)
            }
        }.asFlow()
    }

    override fun getFavoriteTeam(): Flow<List<Team>> {
        return localDataSouce.getFavoriteTeam()
            .map { DataMapperEntityToDomain.mapTeamEntityToDomain(it) }
    }

    override fun setFavoriteTeam(team: Team, state: Boolean) {
        val teamEntity = DataMapperDomainToEntity.mapTeamDomainToEntity(team)
        appExecutors.diskIO().execute { localDataSouce.setFavoriteTeam(teamEntity, state) }
    }


}