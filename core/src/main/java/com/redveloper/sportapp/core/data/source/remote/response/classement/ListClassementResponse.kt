package com.redveloper.sportapp.core.data.source.remote.response.classement

import com.google.gson.annotations.SerializedName

data class ListClassementResponse(
    @field:SerializedName("table")
    val table : List<ClassementResponse>
)