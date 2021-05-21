package com.example.finema.ui.movieDetail

import androidx.lifecycle.MutableLiveData
import com.example.finema.models.movieResponse.MovieDetails
import com.example.finema.api.MoviesRepository
import com.example.finema.ui.base.BaseViewModel
import com.example.finema.ui.movieDetail.MovieDetailsFragment.Companion.KEY
import com.example.finema.util.Coroutines

class MovieDetailsViewModel(
    private val repository: MoviesRepository
) : BaseViewModel() {

    var film = MutableLiveData<MovieDetails>()
    var arg: Long = 0
    var genres = MovieDetailsFragment.STARTING_GENRE_VALUE
    var companies = MovieDetailsFragment.STARTING_COMPANIES_VALUE

    init {
        getMovieDetails()
    }

    private fun getMovieDetails() {
        job = Coroutines.ioThenMan(
            { repository.getMovieDetails(arg) },
            {
                film.value = it
                film.value!!.stringGenres = ""
                film.value!!.stringCompanies = ""

                for (item in it!!.genres) {
                    film.value!!.stringGenres += item.name + "\n"
                }

                for (item in it.productionCompanies) {
                    film.value!!.stringCompanies += item.name + "\t\t" + item.originCountry + "\n"
                }
            }
        )
    }

}