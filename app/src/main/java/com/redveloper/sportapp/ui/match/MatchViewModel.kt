package com.redveloper.sportapp.ui.match

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.redveloper.sportapp.core.domain.usecase.ContentUseCase

class MatchViewModel(private val contentUseCase: ContentUseCase) : ViewModel() {

    fun match(idLeague : String) = contentUseCase.getAllMatchInLeague(idLeague).asLiveData()
}