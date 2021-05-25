package com.example.finema.database

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.finema.models.databaseModels.GenreModel
import com.example.finema.models.databaseModels.MovieModel

interface DatabaseRepository {
    val allGenres: LiveData<List<GenreModel>>

    val allFavourites: LiveData<List<MovieModel>>

//    suspend fun checkFavourite(movieId: Long, onSuccess: () -> Unit)

    suspend fun insert(genre: GenreModel, onSuccess: () -> Unit)

    suspend fun insertFavourite(movie: MovieModel, onSuccess: () -> Unit)

    suspend fun deleteFavourite(onSuccess: () -> Unit)

    fun connectToDatabase(onSuccess: () -> Unit, onFail: (String) -> Unit) {}

    fun signOut() {}

}