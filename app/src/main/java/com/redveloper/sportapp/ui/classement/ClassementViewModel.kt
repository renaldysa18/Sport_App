package com.redveloper.sportapp.ui.classement

import androidx.lifecycle.ViewModel
import com.redveloper.sportapp.domain.usecase.ContentUseCase

class ClassementViewModel(private val contentUseCase: ContentUseCase) : ViewModel() {

    val league = contentUseCase.getSelectedLeague()

    fun classement(idLeague: String) = contentUseCase.getAllClassementInLeague(idLeague, "2020-2021")

}