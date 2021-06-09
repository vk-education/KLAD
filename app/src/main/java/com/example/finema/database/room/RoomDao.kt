package com.example.finema.database.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.finema.models.databaseModels.GenreModel
import com.example.finema.models.databaseModels.MovieModel
import com.example.finema.models.databaseModels.TopModel

// Data Access Object
@Dao
interface RoomDao {
    @Query("SELECT * FROM genre_list")
    fun getAllGenres(): LiveData<List<GenreModel>>

    @Query("SELECT * FROM favourite_list")
    fun getAllFavourites(): LiveData<List<MovieModel>>

    @Query("SELECT * FROM top_list")
    fun getAllTop(): LiveData<List<TopModel>>

    @Query("SELECT id FROM favourite_list WHERE id IN (:movieId)")
    fun checkFavourite(movieId: List<Long>): LiveData<List<Long>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertFavourite(note: MovieModel)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(note: GenreModel)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertTop(movie: TopModel)

    @Query("DELETE FROM favourite_list WHERE id = :movieId;")
    suspend fun deleteFavouriteMovie(movieId: Long)

    @Query("DELETE FROM favourite_list;")
    suspend fun deleteAllFavourite()

    @Delete
    suspend fun deleteFavourite(note: MovieModel)

    @Query("DELETE FROM top_list;")
    suspend fun deleteAllTop()
}
