package com.example.finema.database.room

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.*
import com.example.finema.models.databaseModels.GenreModel
import com.example.finema.models.databaseModels.MovieModel

//Data Access Object
@Dao
interface RoomDao {
    @Query("SELECT * FROM genre_list")
    fun getAllGenres(): LiveData<List<GenreModel>>

    @Query("SELECT * FROM favourite_list")
    fun getAllFavourites(): LiveData<List<MovieModel>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertFavourite(note: MovieModel)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(note: GenreModel)

    @Query("DELETE FROM favourite_list;")
    suspend fun deleteFavourite()
}