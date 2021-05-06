package com.example.finema.ui.higherlower

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.finema.newapi.MoviesRepository
import com.example.finema.repositories.Singleton

@Suppress("UNCHECKED_CAST")
class MoviesViewModelFactory(
) : ViewModelProvider.NewInstanceFactory(){

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return HigherLowerViewModel() as T
    }

}