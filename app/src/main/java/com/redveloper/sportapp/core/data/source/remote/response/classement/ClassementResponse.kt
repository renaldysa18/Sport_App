package com.redveloper.sportapp.core.data.source.remote.response.classement

import com.google.gson.annotations.SerializedName

data class ClassementResponse(
    @field:SerializedName("teamid")
    val idTeam : String,
    @field:SerializedName("name")
    val name : String,
    @field:SerializedName("played")
    val played: Int,
    @field:SerializedName("win")
    val win: Int,
    @field:SerializedName("draw")
    val draw : Int,
    @field:SerializedName("loss")
    val loss : Int,
    @field:SerializedName("total")
    val total : Int
)