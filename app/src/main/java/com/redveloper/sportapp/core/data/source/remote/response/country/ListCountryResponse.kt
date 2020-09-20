package com.redveloper.sportapp.core.data.source.remote.response.country

import com.google.gson.annotations.SerializedName

data class ListCountryResponse(
    @field:SerializedName("countries")
    val countries : List<CountryResponse>
)