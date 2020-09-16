package com.redveloper.sportapp.di

import android.content.Context
import com.redveloper.sportapp.data.Repository
import com.redveloper.sportapp.data.source.local.LocalDataSource
import com.redveloper.sportapp.data.source.local.room.AppDatabase
import com.redveloper.sportapp.data.source.remote.RemoteDataSource
import com.redveloper.sportapp.data.source.remote.network.ApiConfig
import com.redveloper.sportapp.domain.usecase.ContentInteractor
import com.redveloper.sportapp.domain.usecase.ContentUseCaseImpl
import com.redveloper.sportapp.utils.AppExecutors

object Injection {
    fun provideRepository(context: Context) : Repository {
        val database = AppDatabase.getInstance(context)
        val localDataSource = LocalDataSource.getInstance(
            database.ClassementDao(), database.CountryDao(), database.LeagueDao(),
            database.MatchDao(), database.TeamDao()
        )
        val remoteDataSource = RemoteDataSource.getInstance(ApiConfig.provideApiService())
        val appExecutors = AppExecutors()
        return Repository.getInstance(remoteDataSource, localDataSource, appExecutors)
    }

    fun provideContentUseCase(context: Context) : ContentUseCaseImpl {
        val repositoryImpl = provideRepository(context)
        return ContentInteractor(repositoryImpl)
    }
}