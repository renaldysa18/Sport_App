package com.redveloper.sportapp.di

import com.redveloper.sportapp.core.domain.usecase.ContentInteractor
import com.redveloper.sportapp.core.domain.usecase.ContentUseCase
import com.redveloper.sportapp.ui.classement.ClassementViewModel
import com.redveloper.sportapp.ui.detail.team.DetailTeamViewModel
import com.redveloper.sportapp.ui.match.MatchViewModel
import com.redveloper.sportapp.ui.team.TeamViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<ContentUseCase> { ContentInteractor(get()) }
}

val viewModelModule = module {
    viewModel { ClassementViewModel(get()) }
    viewModel { TeamViewModel(get()) }
    viewModel { MatchViewModel(get()) }
    viewModel { DetailTeamViewModel(get()) }
}