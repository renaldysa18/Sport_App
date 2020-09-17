package com.redveloper.sportapp.ui.main

import androidx.lifecycle.ViewModel
import com.redveloper.sportapp.domain.usecase.ContentUseCase

class MainViewModel(contentUsecase : ContentUseCase) : ViewModel(){

    val countries = contentUsecase.getAllCountries()
}