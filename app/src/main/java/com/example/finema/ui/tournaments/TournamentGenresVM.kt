package com.example.finema.ui.tournaments

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.example.finema.api.MoviesApi
import com.example.finema.api.MoviesRepository
import com.example.finema.models.GenreRequest.GenreList
import com.example.finema.models.movieResponse.Movie
import com.example.finema.models.movieResponse.MovieResponse
import com.example.finema.ui.base.BaseViewModel
import com.example.finema.util.Coroutines
import com.example.finema.utlis.REPOSITORY
import kotlinx.coroutines.Job

class TournamentGenresVM(application: Application):BaseViewModel(application) {
    val allGenres = REPOSITORY.allGenres
    private lateinit var job: Job
    private val apiTG = MoviesApi()
    private val repository= MoviesRepository(apiTG)
    var filmListVM = MutableLiveData<List<Movie>>()



    fun getMovies(genre:String){
        job = Coroutines.ioThenMan(
            { repository.getMoviesWithGenre(1,genre) },
            { filmListVM.value = it?.movies }
        )
    }

    override fun onCleared() {
        super.onCleared()
        if(::job.isInitialized) job.cancel()
    }

    fun signOut(){
        REPOSITORY.signOut()
    }
}