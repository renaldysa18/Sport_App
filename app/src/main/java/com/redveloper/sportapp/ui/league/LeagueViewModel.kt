package com.redveloper.sportapp.ui.league

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.redveloper.sportapp.domain.model.League
import com.redveloper.sportapp.domain.usecase.ContentUseCase

class LeagueViewModel(private val contentUsecase: ContentUseCase) : ViewModel() {

    private val countryName: MutableLiveData<String> = MutableLiveData()

    fun setCountryName(name: String) {
        countryName.value = name
    }

    val countries = contentUsecase.getAllCountries()

    val league = Transformations.switchMap(countryName) { name ->
        contentUsecase.getAllLeague(name)
    }

    fun setSelectedLeague(league : League) = contentUsecase.setSelectedLeaegue(league)
}