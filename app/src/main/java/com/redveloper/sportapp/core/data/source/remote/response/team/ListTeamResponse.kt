package com.redveloper.sportapp.core.data.source.remote.response.team

import com.google.gson.annotations.SerializedName

data class ListTeamResponse(
    @field:SerializedName("teams")
    val teams : List<TeamResponse>
)