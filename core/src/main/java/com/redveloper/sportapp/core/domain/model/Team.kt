package com.redveloper.sportapp.core.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Team(
    val id : String,
    val name : String,
    val stadiumLocation : String,
    val teamBadge : String,
    val stadiumThumb : String,
    val nameAlt : String,
    val league : String,
    val description : String,
    val imageFanArt : String,
    val isFavorite : Boolean
) : Parcelable