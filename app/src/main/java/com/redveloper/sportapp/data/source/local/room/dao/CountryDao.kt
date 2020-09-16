package com.redveloper.sportapp.data.source.local.room.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.redveloper.sportapp.data.source.local.entity.CountryEntity

@Dao
abstract class CountryDao : BaseDao<CountryEntity>{

    @Query("SELECT * FROM countryentity")
    abstract fun getAllCountry() : LiveData<List<CountryEntity>>
}