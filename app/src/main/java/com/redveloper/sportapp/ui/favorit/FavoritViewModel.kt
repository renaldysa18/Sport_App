package com.redveloper.sportapp.ui.favorit

import androidx.lifecycle.ViewModel
import com.redveloper.sportapp.domain.usecase.ContentUseCase

class FavoritViewModel(private val contentUseCase: ContentUseCase) : ViewModel(){

    val team = contentUseCase.getFavoriteTeam()
}