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
    suspend fun getAllCountries(): ListCountryResponse

    @GET("search_all_leagues.php?")
    suspend fun getAllLeague(
        @Query("c") country: String,
        @Query("s") type: String = "Soccer"
    ): ListLeagueResponse

    @GET("search_all_teams.php?")
    suspend fun getAllTeamInLeague(
        @Query("l") league: String
    ): ListTeamResponse

    @GET("eventsnextleague.php")
    suspend fun getAllMatchInLeague(
        @Query("id") id : String
    ) : ListMatchResponse

    @GET("lookuptable.php?")
    suspend fun getAllClasemmentInLeague(
        @Query("l") idLeague : String,
        @Query("s") season : String
    ) : ListClassementResponse



}