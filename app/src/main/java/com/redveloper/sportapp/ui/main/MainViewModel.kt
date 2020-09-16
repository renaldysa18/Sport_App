package com.redveloper.sportapp.ui.main

import androidx.lifecycle.ViewModel
import com.redveloper.sportapp.domain.usecase.ContentUseCaseImpl

class MainViewModel(contentUsecase : ContentUseCaseImpl) : ViewModel(){

    val countries = contentUsecase.getAllCountries()
}