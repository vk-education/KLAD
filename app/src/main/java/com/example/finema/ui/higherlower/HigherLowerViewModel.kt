package com.example.finema.ui.higherlower

import androidx.lifecycle.MutableLiveData
import com.example.finema.models.MovieResponse
import com.example.finema.newapi.MoviesRepository
import com.example.finema.ui.base.BaseViewModel
import com.example.finema.util.Coroutines
import kotlinx.coroutines.Job

class HigherLowerViewModel(
    private val repository: MoviesRepository
) : BaseViewModel() {

    private lateinit var job: Job

    private val _movies = MutableLiveData<MovieResponse>()
    val movies: MutableLiveData<MovieResponse>
    get() = _movies

    fun getMovies() {
        for(i in 1..5){
            job = Coroutines.ioThenMain(
                { repository.getMovies(i) },
                { _movies.value = it }
            )
        }
    }

    override fun onCleared() {
        super.onCleared()
        if(::job.isInitialized) job.cancel()
    }
}
