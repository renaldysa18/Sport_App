package com.redveloper.sportapp.core.data.source.remote

import com.redveloper.sportapp.core.data.source.remote.response.league.LeagueResponse

interface LoadLeagueCallback{
    fun onResult(data : ApiResponse<List<LeagueResponse>>)
}