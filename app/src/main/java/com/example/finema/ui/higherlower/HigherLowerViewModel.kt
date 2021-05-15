package com.example.finema.ui.higherlower

import androidx.lifecycle.MutableLiveData
import com.example.finema.models.movieResponse.MovieResponse
import com.example.finema.api.MoviesRepository
import com.example.finema.ui.base.BaseViewModel
import com.example.finema.util.Coroutines

class HigherLowerViewModel(
    private val repository: MoviesRepository
) : BaseViewModel() {

    private val _movies = MutableLiveData<MovieResponse>()
    val movies: MutableLiveData<MovieResponse>
    get() = _movies

    private lateinit var opp : MovieResponse
    var add = 0


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
        for(i in 1..5) {
            job = Coroutines.ioThenMain(
                { repository.getMovies(i) },
                { _movies.value = it },
                { opp = it!! },
                true
            )
        }
    }

    private fun clickedRight() {
        changeMovRes()
        _movies.value = opp
    }

    private fun clickedWrong() {
        getMovies()
    }

    private fun changeMovRes() {
        opp.movies.drop(1)
    }

    fun onMovieClicked(position: Int) {
        when(position){
            add ->
                if (movies.value?.movies?.get(position)?.popularity!!
                    >= movies.value?.movies?.get(position + 1)?.popularity!!
                ) {
                    add += 1
                    clickedRight()
                } else {
                    add = 0
                    clickedWrong()
                }
            add+1 ->
                if (movies.value?.movies?.get(position)?.popularity!!
                    >= movies.value?.movies?.get(position - 1)?.popularity!!
                ) {
                    add += 1
                    clickedRight()
                } else {
                    add = 0
                    clickedWrong()
                }
        }
    }
}



