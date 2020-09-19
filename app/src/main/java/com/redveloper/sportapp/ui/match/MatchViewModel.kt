package com.redveloper.sportapp.ui.match

import androidx.lifecycle.ViewModel
import com.redveloper.sportapp.domain.usecase.ContentUseCase

class MatchViewModel(private val contentUseCase: ContentUseCase) : ViewModel() {

    val league = contentUseCase.getSelectedLeague()

    fun match(idLeague : String) = contentUseCase.getAllMatchInLeague(idLeague)
}