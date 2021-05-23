package com.example.finema.ui.tournaments.tournament

import androidx.lifecycle.MutableLiveData
import com.example.finema.api.MoviesRepository
import com.example.finema.models.movieResponse.Movie
import com.example.finema.ui.base.BaseViewModel
import com.example.finema.util.Coroutines

class TournamentVM(
    private val apiRepository: MoviesRepository,
) : BaseViewModel() {
    var filmListVM = MutableLiveData<List<Movie>>()


    fun getMovies(genre: String) {
        job = Coroutines.ioThenMan(
            { apiRepository.getMoviesWithGenre(1, genre) },
            { filmListVM.value = it?.movies }
        )
    }
}
