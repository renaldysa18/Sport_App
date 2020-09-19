package com.redveloper.sportapp.ui.splash

import androidx.lifecycle.ViewModel
import com.redveloper.sportapp.domain.usecase.ContentUseCase

class SplashViewModel (private val contentUseCase: ContentUseCase) : ViewModel(){

    val league = contentUseCase.checkLeagueHasItem()
}