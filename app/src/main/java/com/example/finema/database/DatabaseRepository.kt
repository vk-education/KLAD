package com.example.finema.database

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.finema.models.databaseModels.GenreModel

interface DatabaseRepository {
    val allGenres: LiveData<List<GenreModel>>

    suspend fun insert(genre: GenreModel,onSuccess:()-> Unit)

    fun connectToDatabase(onSuccess: () -> Unit, onFail: (String)-> Unit){}

    fun signOut(){}

}