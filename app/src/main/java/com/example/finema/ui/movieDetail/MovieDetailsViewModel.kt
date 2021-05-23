package com.example.finema.ui.movieDetail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.finema.models.movieResponse.MovieDetails
import com.example.finema.api.MoviesRepository
import com.example.finema.database.room.RoomRepository
import com.example.finema.models.databaseModels.GenreModel
import com.example.finema.models.databaseModels.MovieModel
import com.example.finema.ui.base.BaseViewModel
import com.example.finema.ui.movieDetail.MovieDetailsFragment.Companion.KEY
import com.example.finema.util.Coroutines
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieDetailsViewModel(
    private val repository: MoviesRepository,
    private val DBRepository: RoomRepository
) : BaseViewModel() {

    var film = MutableLiveData<MovieDetails>()
    var arg: Long = 0

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
                    film.value!!.stringGenres += item.name + NEW_LINE
                }

                for (item in it.productionCompanies) {
                    film.value!!.stringCompanies += item.name + TAB + item.originCountry + NEW_LINE
                }
            }
        )
    }

    fun insert(movieModel: MovieModel) =
        viewModelScope.launch(Dispatchers.Main) {
            DBRepository.insertFavourite(movieModel) {
            }
        }

    companion object{
        const val NEW_LINE = "\n"
        const val TAB = "\t"
    }

}