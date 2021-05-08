package com.example.finema.ui.movieDetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.finema.newapi.MoviesRepository

@Suppress("UNCHECKED_CAST")
class MovieDetailsViewModelFactory() : ViewModelProvider.NewInstanceFactory(){
    override fun <T: ViewModel?> create(modelClass: Class<T>): T {
        return MovieDetailsViewModel() as T
    }
}