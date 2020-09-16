package com.redveloper.sportapp.domain.model

data class Team(
    val id : String,
    val name : String,
    val stadiumLocation : String,
    val teamBadge : String,
    val stadiumThumb : String,
    val nameAlt : String,
    val league : String,
    val description : String,
    val imageFanArt : String
)