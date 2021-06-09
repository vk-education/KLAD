package com.example.finema.ui.favourite

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.finema.database.DatabaseRepository
import com.example.finema.models.databaseModels.MovieModel
import com.example.finema.ui.base.BaseViewModel

class FavouriteViewModel(
    private val dbRepository: DatabaseRepository
) : BaseViewModel() {

    val favouriteMovies: LiveData<List<MovieModel>> = dbRepository.allFavourites

    init {
        Log.d("gypsy", "DB")

        Log.d("gypsy", favouriteMovies.value.toString())
    }
}
