package com.redveloper.sportapp.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class LeagueEntity(
    @ColumnInfo(name = "idLeague")
    val idLeague : String,
    @ColumnInfo(name = "name")
    val name : String,
    @ColumnInfo(name = "logo")
    val logo : String?,
    @ColumnInfo(name = "gender")
    val gender : String
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id : Int = 0
}