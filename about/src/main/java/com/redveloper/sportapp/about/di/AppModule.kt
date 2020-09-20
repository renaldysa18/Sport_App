package com.redveloper.sportapp.about.di

import com.redveloper.sportapp.about.AboutViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val aboutModule = module {
    viewModel { AboutViewModel(get()) }
}