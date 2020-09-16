package com.redveloper.sportapp.data.source.local.room.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.redveloper.sportapp.data.source.local.entity.MatchEntity

@Dao
abstract class MatchDao : BaseDao<MatchEntity> {

    @Query("SELECT * FROM matchentity")
    abstract fun getAllMatch() : LiveData<List<MatchEntity>>
}