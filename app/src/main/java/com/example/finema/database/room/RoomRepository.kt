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

    override fun checkFavourite(movieId: Long) = roomDao.checkFavourite(movieId)

    override suspend fun insert(genre: GenreModel, onSuccess: () -> Unit) {
        roomDao.insert(genre)
        onSuccess()
    }

    override suspend fun insertFavourite(movie: MovieModel, onSuccess: () -> Unit) {
        roomDao.insertFavourite(movie)
        onSuccess()
    }

    override suspend fun deleteAllFavourite(onSuccess: () -> Unit) {
        roomDao.deleteAllFavourite()
        onSuccess()
    }

    override suspend fun deleteFavouriteMovie(movieId: Long, onSuccess: () -> Unit) {
        roomDao.deleteFavouriteMovie(movieId)
        onSuccess()
    }

    override suspend fun deleteFavourite(movie: MovieModel, onSuccess: () -> Unit) {
        roomDao.deleteFavourite(movie)
        onSuccess()
    }

    override fun signOut(){
    }
}