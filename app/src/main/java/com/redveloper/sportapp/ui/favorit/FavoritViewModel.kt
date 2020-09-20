package com.redveloper.sportapp.ui.favorit

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.redveloper.sportapp.domain.usecase.ContentUseCase

class FavoritViewModel(private val contentUseCase: ContentUseCase) : ViewModel(){

    val team = contentUseCase.getFavoriteTeam().asLiveData()
}