package com.redveloper.sportapp.data.source.local.room.dao

import androidx.room.Dao
import androidx.room.Query
import com.redveloper.sportapp.data.source.local.entity.CountryEntity
import kotlinx.coroutines.flow.Flow

@Dao
abstract class CountryDao : BaseDao<CountryEntity> {

    @Query("SELECT * FROM countryentity")
    abstract fun getAllCountry(): Flow<List<CountryEntity>>
}