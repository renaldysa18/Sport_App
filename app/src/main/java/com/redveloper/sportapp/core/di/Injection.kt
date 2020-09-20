package com.redveloper.sportapp.core.di

import android.content.Context
import com.redveloper.sportapp.core.data.Repository
import com.redveloper.sportapp.core.data.source.local.LocalDataSource
import com.redveloper.sportapp.core.data.source.local.room.AppDatabase
import com.redveloper.sportapp.core.data.source.remote.RemoteDataSource
import com.redveloper.sportapp.core.data.source.remote.network.ApiConfig
import com.redveloper.sportapp.core.domain.usecase.ContentInteractor
import com.redveloper.sportapp.core.domain.usecase.ContentUseCase
import com.redveloper.sportapp.core.utils.AppExecutors

object Injection {
    fun provideRepository(context: Context) : Repository {
        val database = AppDatabase.getInstance(context)
        val localDataSource = LocalDataSource.getInstance(
            database.ClassementDao(),
            database.MatchDao(), database.TeamDao()
        )
        val remoteDataSource = RemoteDataSource.getInstance(ApiConfig.provideApiService())
        val appExecutors = AppExecutors()
        return Repository.getInstance(remoteDataSource, localDataSource, appExecutors)
    }

    fun provideContentUseCase(context: Context) : ContentUseCase {
        val repositoryImpl = provideRepository(context)
        return ContentInteractor(repositoryImpl)
    }
}