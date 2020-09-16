package com.redveloper.sportapp.data.source.remote.response.league

import com.google.gson.annotations.SerializedName

data class ListLeagueResponse(
    @field:SerializedName("countrys")
    val countrys : List<LeagueResponse>
)