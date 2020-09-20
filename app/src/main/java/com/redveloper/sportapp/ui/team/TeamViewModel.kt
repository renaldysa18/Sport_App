package com.redveloper.sportapp.ui.team

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.redveloper.sportapp.core.domain.usecase.ContentUseCase

class TeamViewModel(private val contentUseCase: ContentUseCase) : ViewModel() {

    fun getAllTeam(league: String) = contentUseCase.getAllTeamInLeague(league).asLiveData()
}