package com.redveloper.sportapp.core.data.source.remote.response.country

import com.google.gson.annotations.SerializedName

data class CountryResponse(
    @field:SerializedName("name_en")
    val name : String
)