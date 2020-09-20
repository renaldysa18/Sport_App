package com.redveloper.sportapp.data.source.remote

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.redveloper.sportapp.data.source.remote.network.ApiService
import com.redveloper.sportapp.data.source.remote.response.classement.ClassementResponse
import com.redveloper.sportapp.data.source.remote.response.classement.ListClassementResponse
import com.redveloper.sportapp.data.source.remote.response.country.CountryResponse
import com.redveloper.sportapp.data.source.remote.response.country.ListCountryResponse
import com.redveloper.sportapp.data.source.remote.response.league.LeagueResponse
import com.redveloper.sportapp.data.source.remote.response.league.ListLeagueResponse
import com.redveloper.sportapp.data.source.remote.response.match.ListMatchResponse
import com.redveloper.sportapp.data.source.remote.response.match.MatchResponse
import com.redveloper.sportapp.data.source.remote.response.team.ListTeamResponse
import com.redveloper.sportapp.data.source.remote.response.team.TeamResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteDataSource private constructor(private val apiService: ApiService) {

    companion object {
        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(service: ApiService): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource(service)
            }
    }

    fun getAllCountries(): Flow<ApiResponse<List<CountryResponse>>> {
       return flow {
           try {
               val response = apiService.getAllCountries()
               val dataArray = response.countries
               if (dataArray.isNotEmpty()){
                   emit(ApiResponse.Success(response.countries))
               } else {
                   emit(ApiResponse.Empty)
               }
           }catch (e: Exception){
               emit(ApiResponse.Error(e.toString()))
               Log.e("ErrorRDSCountries", e.toString())
           }
       }.flowOn(Dispatchers.IO)
    }

    fun getAllLeague(country: String) : Flow<ApiResponse<List<LeagueResponse>>> {
        return flow {
            try {
                val response = apiService.getAllLeague(country)
                val dataArray = response.countrys
                if (dataArray.isNotEmpty()){
                    emit(ApiResponse.Success(response.countrys))
                } else {
                    emit(ApiResponse.Empty)
                }
            }catch (e: Exception){
                emit(ApiResponse.Error(e.toString()))
                Log.e("ErrorRDSLeague", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }

    fun getAllTeamInLeague(league: String): Flow<ApiResponse<List<TeamResponse>>> {
       return flow {
           try {
               val response = apiService.getAllTeamInLeague(league)
               val dataArray = response.teams
               if (dataArray.isNotEmpty()){
                   emit(ApiResponse.Success(response.teams))
               } else {
                   emit(ApiResponse.Empty)
               }
           }catch (e: Exception){
               emit(ApiResponse.Error(e.toString()))
               Log.e("ErrorRDSTeam", e.toString())
           }
       }.flowOn(Dispatchers.IO)
    }

    fun getAllMatchInLeague(idLeague: String): Flow<ApiResponse<List<MatchResponse>>> {
        return flow {
            try {
                val response = apiService.getAllMatchInLeague(idLeague)
                val dataArray = response.events
                if (dataArray.isNotEmpty()){
                    emit(ApiResponse.Success(dataArray))
                } else {
                    emit(ApiResponse.Empty)
                }
            }catch (e: Exception){
                emit(ApiResponse.Error(e.toString()))
                Log.e("ErrorRDSMatch", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }

    fun getAllClasementInLeague(idLeague: String, seasson: String) : Flow<ApiResponse<List<ClassementResponse>>>{
        return flow {
            try {
                val response = apiService.getAllClasemmentInLeague(idLeague, seasson)
                val dataArray = response.table
                if (dataArray.isNotEmpty()){
                    emit(ApiResponse.Success(dataArray))
                } else {
                    emit(ApiResponse.Empty)
                }
            }catch (e: Exception){
                emit(ApiResponse.Error(e.toString()))
                Log.e("ErrorRDSMatch", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }


}