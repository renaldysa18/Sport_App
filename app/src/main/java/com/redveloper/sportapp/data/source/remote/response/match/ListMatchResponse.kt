package com.redveloper.sportapp.data.source.remote.response.match

import com.google.gson.annotations.SerializedName

data class ListMatchResponse(
    @field:SerializedName("events")
    val events : List<MatchResponse>
)