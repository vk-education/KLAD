package com.example.finema.ui.higherlower

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.finema.api.MoviesRepository

@Suppress("UNCHECKED_CAST")
class MoviesViewModelFactory(
    private val repository: MoviesRepository
) : ViewModelProvider.NewInstanceFactory(){

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return HigherLowerViewModel(repository) as T
    }

}