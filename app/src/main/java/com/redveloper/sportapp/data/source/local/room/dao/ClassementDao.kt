package com.redveloper.sportapp.data.source.local.room.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.redveloper.sportapp.data.source.local.entity.ClassementEntity

@Dao
abstract class ClassementDao : BaseDao<ClassementEntity> {

    @Query("SELECT * FROM classemententity")
    abstract fun getAllClassement() : LiveData<List<ClassementEntity>>
}