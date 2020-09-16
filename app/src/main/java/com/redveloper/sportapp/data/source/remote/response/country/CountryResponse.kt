package com.redveloper.sportapp.data.source.remote.response.country

import com.google.gson.annotations.SerializedName

data class CountryResponse(
    @field:SerializedName("name_en")
    val name : String
)