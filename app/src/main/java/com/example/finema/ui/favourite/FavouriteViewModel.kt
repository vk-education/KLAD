package com.example.finema.ui.favourite

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.finema.api.MoviesRepository
import com.example.finema.database.room.RoomRepository
import com.example.finema.models.databaseModels.MovieModel
import com.example.finema.ui.base.BaseViewModel
import com.example.finema.ui.movieDetail.MovieDetailsViewModel
import com.example.finema.util.Coroutines

class FavouriteViewModel (
    private val DBRepository: RoomRepository
) : BaseViewModel() {

    var favouriteMovies: LiveData<List<MovieModel>>? = null

    init{
        Log.d("gypsy", "DB")
        favouriteMovies = DBRepository.allFavourites

        Log.d("gypsy", favouriteMovies?.value.toString())
    }

}