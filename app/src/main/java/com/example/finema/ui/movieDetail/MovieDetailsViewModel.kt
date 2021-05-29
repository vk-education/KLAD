package com.example.finema.ui.movieDetail

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.finema.models.movieResponse.MovieDetails
import com.example.finema.api.MoviesRepository
import com.example.finema.database.room.RoomRepository
import com.example.finema.models.databaseModels.MovieModel
import com.example.finema.models.databaseModels.TopModel
import com.example.finema.ui.base.BaseViewModel
import com.example.finema.util.Coroutines
import kotlinx.coroutines.*

class MovieDetailsViewModel(
    private val repository: MoviesRepository,
    private val DBRepository: RoomRepository
) : BaseViewModel() {

    var film = MutableLiveData<MovieDetails>()
    var arg: Long = 0
    var favouriteMovies: List<Long>? = null

     fun getMovieDetails() {
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

                Log.d("gypsy", "Details")
            }
        )
    }

    fun insert(movieModel: MovieModel) =
        viewModelScope.launch(Dispatchers.Main) {
            DBRepository.insertFavourite(movieModel) {
            }
        }

    fun checkFavourite() {
        GlobalScope.launch {
            favouriteMovies = DBRepository.checkFavourite(arg)
            Log.d("gypsy", "Check")
            Log.d("gypsy", arg.toString())
        }
    }

    fun toTopModel(movieModel: MovieModel): TopModel {
        return TopModel(
            movieModel.id,
            movieModel.title,
            null,
            movieModel.about,
            null,
            movieModel.rating,
            null
        )
    }

    fun deleteMovie(id: Long) {
        viewModelScope.launch(Dispatchers.Main) {
            DBRepository.deleteFavouriteMovie(id) {}
        }

    }

    suspend fun addToTopMovies(movieModel: TopModel) {
        DBRepository.insertTop(movieModel){}
    }

    companion object {
        const val NEW_LINE = "\n"
        const val TAB = "\t"
    }

}