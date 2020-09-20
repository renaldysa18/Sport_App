package com.redveloper.sportapp.core.data.source.remote.response.match

import com.google.gson.annotations.SerializedName

data class ListMatchResponse(
    @field:SerializedName("events")
    val events : List<MatchResponse>
)