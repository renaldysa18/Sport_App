package com.redveloper.sportapp.favorit.di

import com.redveloper.sportapp.favorit.FavoritViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val favoritModule = module {
    viewModel { FavoritViewModel(get()) }
}