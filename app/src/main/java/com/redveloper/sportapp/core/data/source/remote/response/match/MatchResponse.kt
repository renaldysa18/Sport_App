package com.redveloper.sportapp.core.data.source.remote.response.match

import com.google.gson.annotations.SerializedName

data class MatchResponse(
    @field:SerializedName("idEvent")
    val idEvent: String,
    @field:SerializedName("strEvent")
    val strEvent : String,
    @field:SerializedName("strThumb")
    val strThumb : String?
)