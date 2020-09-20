package com.redveloper.sportapp.core.data.source.local.room.dao

import androidx.room.Dao
import androidx.room.Query
import com.redveloper.sportapp.core.data.source.local.entity.ClassementEntity
import kotlinx.coroutines.flow.Flow

@Dao
abstract class ClassementDao : BaseDao<ClassementEntity> {

    @Query("SELECT * FROM classemententity")
    abstract fun getAllClassement(): Flow<List<ClassementEntity>>
}