package com.redveloper.sportapp.data.source.remote

import androidx.lifecycle.LiveData
import com.redveloper.sportapp.data.source.remote.response.league.LeagueResponse

interface LoadLeagueCallback{
    fun onResult(data : ApiResponse<List<LeagueResponse>>)
}