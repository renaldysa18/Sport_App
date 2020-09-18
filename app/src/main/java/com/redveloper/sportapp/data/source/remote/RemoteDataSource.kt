package com.redveloper.sportapp.data.source.remote

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

    fun getAllCountries(): LiveData<ApiResponse<List<CountryResponse>>> {
        val result = MutableLiveData<ApiResponse<List<CountryResponse>>>()
        val client = apiService.getAllCountries()
        client.enqueue(object : Callback<ListCountryResponse> {
            override fun onFailure(call: Call<ListCountryResponse>, t: Throwable) {
                result.value = ApiResponse.error(t.message.toString())
            }

            override fun onResponse(
                call: Call<ListCountryResponse>,
                response: Response<ListCountryResponse>
            ) {
                val dataArray = response.body()?.countries
                if (dataArray != null) {
                    result.value = ApiResponse.success(dataArray)
                }
            }
        })
        return result
    }

    fun getAllLeague(country: String, callback : LoadLeagueCallback){
        val client = apiService.getAllLeague(country)
        client.enqueue(object : Callback<ListLeagueResponse> {
            override fun onFailure(call: Call<ListLeagueResponse>, t: Throwable) {
                callback.onResult(ApiResponse.error(t.message.toString()))
            }
            override fun onResponse(
                call: Call<ListLeagueResponse>,
                response: Response<ListLeagueResponse>
            ) {
                val dataArray = response.body()?.countrys
                if (dataArray != null) {
                    callback.onResult(ApiResponse.success(dataArray))
                }
            }
        })
    }

    fun getAllTeamInLeague(league: String): LiveData<ApiResponse<List<TeamResponse>>> {
        val result = MutableLiveData<ApiResponse<List<TeamResponse>>>()
        val client = apiService.getAllTeamInLeague(league)
        client.enqueue(object : Callback<ListTeamResponse> {
            override fun onFailure(call: Call<ListTeamResponse>, t: Throwable) {
                result.value = ApiResponse.error(t.message.toString())
            }

            override fun onResponse(
                call: Call<ListTeamResponse>,
                response: Response<ListTeamResponse>
            ) {
                val dataArray = response.body()?.teams
                if (dataArray != null) {
                    result.value = ApiResponse.success(dataArray)
                }
            }
        })
        return result
    }

    fun getDetailTeam(idteam: String): LiveData<ApiResponse<TeamResponse>> {
        val result = MutableLiveData<ApiResponse<TeamResponse>>()
        val client = apiService.getDetailTeam(idteam)
        client.enqueue(object : Callback<TeamResponse> {
            override fun onFailure(call: Call<TeamResponse>, t: Throwable) {
                result.value = ApiResponse.error(t.message.toString())
            }

            override fun onResponse(call: Call<TeamResponse>, response: Response<TeamResponse>) {
                val data = response.body()
                if (data != null) {
                    val teamModel = TeamResponse(
                        data.idTeam, data.strTeam, data.strStadiumLocation,
                        data.strTeamBadge, data.strStadiumThumb, data.strAltName,
                        data.strLeague, data.strDescription, data.strImageFanArt
                    )
                    result.value = ApiResponse.success(teamModel)
                }
            }
        })
        return result
    }

    fun getAllMatchInLeague(idLeague: String): LiveData<ApiResponse<List<MatchResponse>>> {
        val result = MutableLiveData<ApiResponse<List<MatchResponse>>>()
        val client = apiService.getAllMatchInLeague(idLeague)
        client.enqueue(object : Callback<ListMatchResponse>{
            override fun onFailure(call: Call<ListMatchResponse>, t: Throwable) {
                result.value = ApiResponse.error(t.message.toString())
            }

            override fun onResponse(
                call: Call<ListMatchResponse>,
                response: Response<ListMatchResponse>
            ) {
                val dataArray = response.body()?.events
                if (dataArray != null){
                    result.value = ApiResponse.success(dataArray)
                }
            }
        })
        return result
    }

    fun getAllClasementInLeague(idLeague: String, seasson: String) : LiveData<ApiResponse<List<ClassementResponse>>>{
        val result = MutableLiveData<ApiResponse<List<ClassementResponse>>>()
        val client = apiService.getAllClasemmentInLeague(idLeague, seasson)
        client.enqueue(object : Callback<ListClassementResponse>{
            override fun onFailure(call: Call<ListClassementResponse>, t: Throwable) {
                result.value = ApiResponse.error(t.message.toString())
            }

            override fun onResponse(
                call: Call<ListClassementResponse>,
                response: Response<ListClassementResponse>
            ) {
                val dataArray = response.body()?.table
                if (dataArray != null){
                    result.value = ApiResponse.success(dataArray)
                }
            }
        })
        return result
    }


}