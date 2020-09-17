package com.redveloper.sportapp.ui.league

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.redveloper.sportapp.domain.usecase.ContentUseCase

class LeagueViewModel (contentUsecase : ContentUseCase) : ViewModel() {

    private val countryName : MutableLiveData<String> = MutableLiveData()

    fun setCountryName(name : String){
        countryName.value = name
    }

    val countries = contentUsecase.getAllCountries()

    val league = Transformations.switchMap(countryName){name ->
        contentUsecase.getAllLeague(name)
    }
}