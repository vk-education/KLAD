package com.example.finema.ui.higherlower

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.example.finema.api.MoviesApi
import com.example.finema.models.movieResponse.MovieResponse
import com.example.finema.api.MoviesRepository
import com.example.finema.ui.base.BaseViewModel
import com.example.finema.util.Coroutines
import kotlinx.coroutines.Job

class HigherLowerViewModel(
    application: Application
) : BaseViewModel(application = application) {

    //TODO getMovies
    init {

    }

    private val api = MoviesApi()
    private val repository = MoviesRepository(api)

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
