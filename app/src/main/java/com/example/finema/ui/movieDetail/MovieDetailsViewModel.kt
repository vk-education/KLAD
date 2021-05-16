package com.example.finema.ui.movieDetail

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.example.finema.api.MoviesApi
import com.example.finema.models.movieResponse.MovieDetails
import com.example.finema.api.MoviesRepository
import com.example.finema.ui.base.BaseViewModel
import com.example.finema.util.Coroutines
import kotlinx.coroutines.Job

//TODO изменить по аналогии с правками остальных VM
class MovieDetailsViewModel(
    private val repository : MoviesRepository
) : BaseViewModel() {

    var film = MutableLiveData<MovieDetails>()

    fun getMovieDetails(id: Long) {
        job = Coroutines.ioThenMan(
            { repository.getMovieDetails(id) },
            { film.value = it }
        )
    }

}