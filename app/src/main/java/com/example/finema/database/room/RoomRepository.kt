package com.example.finema.database.room

import androidx.lifecycle.LiveData
import com.example.finema.database.DatabaseRepository
import com.example.finema.models.databaseModels.GenreModel

class RoomRepository(private val roomDao: RoomDao):DatabaseRepository {

    override val allGenres: LiveData<List<GenreModel>>
        get() = roomDao.getAllGenres()


    override suspend fun insert(genre: GenreModel, onSuccess: () -> Unit) {
        roomDao.insert(genre)
        onSuccess()
    }


    override fun signOut(){

    }
}