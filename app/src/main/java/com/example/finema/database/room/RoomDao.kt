package com.example.finema.database.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.finema.models.databaseModels.GenreModel

//Data Access Object
@Dao
interface RoomDao {
    @Query("SELECT * FROM genre_list")
    fun getAllGenres(): LiveData<List<GenreModel>>


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(note: GenreModel)
}