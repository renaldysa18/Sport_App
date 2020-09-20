package com.redveloper.sportapp.about

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.redveloper.sportapp.core.domain.usecase.ContentUseCase

class AboutViewModel (contentUseCase: ContentUseCase) : ViewModel(){

    val favorit = contentUseCase.getFavoriteTeam().asLiveData()
}