package com.redveloper.sportapp.data.source.remote.response.country

import com.google.gson.annotations.SerializedName

data class ListCountryResponse(
    @field:SerializedName("countries")
    val countries : List<CountryResponse>
)