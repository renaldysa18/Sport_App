package com.redveloper.sportapp.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.redveloper.sportapp.di.Injection
import com.redveloper.sportapp.domain.usecase.ContentUseCase
import com.redveloper.sportapp.ui.classement.ClassementViewModel
import com.redveloper.sportapp.ui.league.LeagueViewModel
import com.redveloper.sportapp.ui.main.MainViewModel
import com.redveloper.sportapp.ui.match.MatchViewModel
import com.redveloper.sportapp.ui.splash.SplashViewModel
import com.redveloper.sportapp.ui.team.TeamViewModel

class ViewModelFactory private constructor(private val contentUseCase : ContentUseCase) : ViewModelProvider.NewInstanceFactory(){

    companion object{
        @Volatile
        private var instance : ViewModelFactory? = null

        fun getInstance(context: Context) : ViewModelFactory =
            instance ?: synchronized(this){
                instance ?: ViewModelFactory(
                    Injection.provideContentUseCase(context)
                )
            }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when{
            modelClass.isAssignableFrom(MainViewModel::class.java) -> {
                MainViewModel(contentUseCase) as T
            }
            modelClass.isAssignableFrom(SplashViewModel::class.java) -> {
                SplashViewModel(contentUseCase) as T
            }
            modelClass.isAssignableFrom(LeagueViewModel::class.java) -> {
                LeagueViewModel(contentUseCase) as T
            }
            modelClass.isAssignableFrom(ClassementViewModel::class.java) -> {
                ClassementViewModel(contentUseCase) as T
            }
            modelClass.isAssignableFrom(TeamViewModel::class.java) -> {
                TeamViewModel(contentUseCase) as T
            }
            modelClass.isAssignableFrom(MatchViewModel::class.java) -> {
                MatchViewModel(contentUseCase) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
    }
}