package com.redveloper.sportapp.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.redveloper.sportapp.di.Injection
import com.redveloper.sportapp.domain.usecase.ContentUseCaseImpl
import com.redveloper.sportapp.ui.main.MainViewModel

class ViewModelFactory private constructor(private val contentUseCase : ContentUseCaseImpl) : ViewModelProvider.NewInstanceFactory(){

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

            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
    }
}