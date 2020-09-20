package com.redveloper.sportapp.ui.classement

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.redveloper.sportapp.domain.usecase.ContentUseCase

class ClassementViewModel(private val contentUseCase: ContentUseCase) : ViewModel() {

    fun classement(idLeague: String) =
        contentUseCase.getAllClassementInLeague(idLeague, "2020-2021").asLiveData()

}