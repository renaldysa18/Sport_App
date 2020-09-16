package com.redveloper.sportapp.data.source.remote.response.team

import com.google.gson.annotations.SerializedName

data class TeamResponse(
    @field:SerializedName("idTeam")
    val idTeam : String,
    @field:SerializedName("strTeam")
    val strTeam : String,
    @field:SerializedName("strStadiumLocation")
    val strStadiumLocation : String,
    @field:SerializedName("strTeamBadge")
    val strTeamBadge : String,
    @field:SerializedName("strStadiumThumb")
    val strStadiumThumb : String,
    @field:SerializedName("strAlternate")
    val strAltName : String,
    @field:SerializedName("strLeague")
    val strLeague : String,
    @field:SerializedName("strDescriptionEN")
    val strDescription : String,
    @field:SerializedName("strTeamFanart1")
    val strImageFanArt : String
)