package com.redveloper.sportapp.core.domain.model

data class League(
    val id : String,
    val name : String,
    val logo : String?,
    val gender : String,
    val selected : Boolean
)