package com.redveloper.sportapp.core.data.source.local.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity
data class TeamEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id : String,
    @ColumnInfo(name = "name")
    val name : String,
    @ColumnInfo(name = "stadiumLocation")
    val stadiumLocation : String,
    @ColumnInfo(name = "teamBadge")
    val teamBadge : String,
    @ColumnInfo(name = "stadiumThumb")
    val stadiumThumb : String,
    @ColumnInfo(name = "nameAlt")
    val nameAlt : String,
    @ColumnInfo(name = "league")
    val league : String,
    @ColumnInfo(name = "description")
    val description : String,
    @ColumnInfo(name = "imageFanart")
    val imageFanart : String,
    @ColumnInfo(name = "isFavorite")
    var isFavorite : Boolean = false
) : Parcelable