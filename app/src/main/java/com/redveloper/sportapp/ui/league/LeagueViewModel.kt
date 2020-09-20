package com.redveloper.sportapp.ui.league

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.redveloper.sportapp.domain.model.League
import com.redveloper.sportapp.domain.usecase.ContentUseCase

class LeagueViewModel(private val contentUsecase: ContentUseCase) : ViewModel() {

    private val countryName: MutableLiveData<String> = MutableLiveData()

    fun setCountryName(name: String) {
        countryName.value = name
    }

    val countries = contentUsecase.getAllCountries().asLiveData()

    val league = contentUsecase.getAllLeague("England").asLiveData()

}