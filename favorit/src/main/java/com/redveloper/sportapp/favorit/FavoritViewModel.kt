package com.redveloper.sportapp.favorit

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.redveloper.sportapp.core.domain.usecase.ContentUseCase

class FavoritViewModel(private val contentUseCase: ContentUseCase) : ViewModel(){

    val team = contentUseCase.getFavoriteTeam().asLiveData()
}