package com.redveloper.sportapp.ui.detail.team

import androidx.lifecycle.ViewModel
import com.redveloper.sportapp.core.domain.model.Team
import com.redveloper.sportapp.core.domain.usecase.ContentUseCase

class DetailTeamViewModel (private val contentUseCase: ContentUseCase) : ViewModel(){
    fun setFavoriteTeam(team : Team, state : Boolean) = contentUseCase.setFavoriteTeam(team, state)
}