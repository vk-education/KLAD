package com.example.finema.database.room

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.finema.database.DatabaseRepository
import com.example.finema.models.databaseModels.GenreModel
import com.example.finema.models.databaseModels.MovieModel

class RoomRepository (
    private val roomDao: RoomDao
    ): DatabaseRepository {

    override val allGenres: LiveData<List<GenreModel>> = roomDao.getAllGenres()

    override val allFavourites: LiveData<List<MovieModel>> = roomDao.getAllFavourites()

    override suspend fun insert(genre: GenreModel, onSuccess: () -> Unit) {
        roomDao.insert(genre)
        onSuccess()
    }

    override suspend fun insertFavourite(movie: MovieModel, onSuccess: () -> Unit) {
        roomDao.insertFavourite(movie)
        onSuccess()
    }

    override suspend fun deleteFavourite(onSuccess: () -> Unit) {
        roomDao.deleteFavourite()
        onSuccess()
    }

    override fun signOut(){
    }
}