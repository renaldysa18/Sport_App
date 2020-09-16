package com.redveloper.sportapp.domain.model

data class Classement(
    val id : String,
    val name : String,
    val played : Int,
    val win : Int,
    val draw : Int,
    val loss : Int,
    val total : Int
)