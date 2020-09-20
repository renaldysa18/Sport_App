package com.redveloper.sportapp.core.data.source.remote.response.league

import com.google.gson.annotations.SerializedName

data class LeagueResponse(
    @field:SerializedName("idLeague")
    val idLeague : String,
    @field:SerializedName("strLeague")
    val strLeague : String,
    @field:SerializedName("strLogo")
    val strLogo : String,
    @field:SerializedName("strGender")
    val strGender : String
)