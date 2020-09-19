package com.redveloper.sportapp.ui.team

import androidx.lifecycle.ViewModel
import com.redveloper.sportapp.domain.usecase.ContentUseCase

class TeamViewModel(private val contentUseCase: ContentUseCase) : ViewModel() {

    val league = contentUseCase.getSelectedLeague()

    fun getAllTeam(league: String) = contentUseCase.getAllTeamInLeague(league)
}