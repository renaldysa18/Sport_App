package com.redveloper.sportapp.core.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ClassementEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: String,
    @ColumnInfo(name = "name")
    val name : String,
    @ColumnInfo(name = "played")
    val played: Int,
    @ColumnInfo(name = "win")
    val win : Int,
    @ColumnInfo(name = "draw")
    val draw : Int,
    @ColumnInfo(name = "loss")
    val loss : Int,
    @ColumnInfo(name = "total")
    val total : Int
)