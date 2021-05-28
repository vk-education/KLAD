package com.example.finema.database.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.finema.models.databaseModels.GenreModel
import com.example.finema.models.databaseModels.MovieModel
import com.example.finema.models.databaseModels.TopModel


@Database(entities = [GenreModel::class, MovieModel::class, TopModel::class], version = 6)
abstract class RoomDataBase(
) : RoomDatabase() {

    abstract fun getRoomDao(): RoomDao

    companion object{

        @Volatile
        private var database: RoomDataBase? = null

        @Synchronized
        fun getInstance(context: Context): RoomDataBase {
            return if (database == null){
                database = Room
                    .databaseBuilder(
                        context,
                        RoomDataBase::class.java,
                        "database"
                    )
                    .fallbackToDestructiveMigration().build()

                database as RoomDataBase
            } else database as RoomDataBase

        }
    }
}