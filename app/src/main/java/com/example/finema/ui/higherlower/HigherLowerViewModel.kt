package com.example.finema.ui.higherlower

import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.finema.api.MoviesApi
import com.example.finema.models.movieResponse.MovieResponse
import com.example.finema.api.MoviesRepository
import com.example.finema.models.movieResponse.Movie
import com.example.finema.ui.base.BaseViewModel
import com.example.finema.util.Coroutines
import org.koin.androidx.compose.getViewModel
import org.koin.androidx.viewmodel.ext.android.getViewModel

class HigherLowerViewModel(
    private val repository: MoviesRepository
) : BaseViewModel() {

    private val _movies = MutableLiveData<MovieResponse>()
    val movies: MutableLiveData<MovieResponse>
    get() = _movies

    private lateinit var opp : MovieResponse

    //TODO getMovies
    init {
        for(i in 1..5)
        {
            job = Coroutines.ioThenMain (
                { repository.getMovies(i) },
                { _movies.value = it },
                { opp = it!! },
                false
            )
        }
    }

    private fun getMovies() {
        for(i in 1..5){
            job = Coroutines.ioThenMain(
                { repository.getMovies(i) },
                { _movies.value = it },
                { opp = it!! },
                true
            )
        }
    }

    fun clickedRight() {
        changeMovRes()
        _movies.value = opp
    }

    fun clickedWrong() {
        getMovies()
    }

    private fun changeMovRes() {
        opp.movies.drop(1)
    }
}


