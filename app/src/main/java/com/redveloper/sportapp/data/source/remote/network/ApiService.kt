package com.redveloper.sportapp.data.source.remote.network

import com.redveloper.sportapp.data.source.remote.response.classement.ListClassementResponse
import com.redveloper.sportapp.data.source.remote.response.country.ListCountryResponse
import com.redveloper.sportapp.data.source.remote.response.league.ListLeagueResponse
import com.redveloper.sportapp.data.source.remote.response.match.ListMatchResponse
import com.redveloper.sportapp.data.source.remote.response.team.ListTeamResponse
import com.redveloper.sportapp.data.source.remote.response.team.TeamResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("all_countries.php")
    fun getAllCountries(): Call<ListCountryResponse>

    @GET("search_all_leagues.php?")
    fun getAllLeague(
        @Query("c") country: String,
        @Query("s") type: String = "Soccer"
    ): Call<ListLeagueResponse>

    @GET("search_all_teams.php?")
    fun getAllTeamInLeague(
        @Query("l") league: String
    ): Call<ListTeamResponse>

    @GET("lookupteam.php?")
    fun getDetailTeam(
        @Query("id") id: String
    ): Call<TeamResponse>

    @GET("eventsnextleague.php")
    fun getAllMatchInLeague(
        @Query("id") id : String
    ) : Call<ListMatchResponse>

    @GET("lookuptable.php?")
    fun getAllClasemmentInLeague(
        @Query("l") idLeague : String,
        @Query("s") season : String
    ) : Call<ListClassementResponse>



}