package com.redveloper.sportapp.core.data.source.remote.response.league

import com.google.gson.annotations.SerializedName

data class ListLeagueResponse(
    @field:SerializedName("countrys")
    val countrys : List<LeagueResponse>
)