package com.redveloper.sportapp

import android.app.Application
import com.redveloper.sportapp.core.di.databaseModule
import com.redveloper.sportapp.core.di.networkModule
import com.redveloper.sportapp.core.di.repositoryModule
import com.redveloper.sportapp.di.useCaseModule
import com.redveloper.sportapp.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MyApplication : Application(){
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@MyApplication)
            modules(
                listOf(
                    databaseModule,
                    networkModule,
                    repositoryModule,
                    useCaseModule,
                    viewModelModule
                )
            )
        }
    }
}