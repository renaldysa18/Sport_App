package com.redveloper.sportapp.ui.league

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.redveloper.sportapp.domain.model.League
import com.redveloper.sportapp.domain.usecase.ContentUseCase

class LeagueViewModel(private val contentUsecase: ContentUseCase) : ViewModel() {

    val countries = contentUsecase.getAllCountries().asLiveData()

    fun getLeague(country: String) = contentUsecase.getAllLeague(country).asLiveData()

    fun setSelectedLeague(league : League, state : Boolean) = contentUsecase.setSelectedLeague(league, state)

}