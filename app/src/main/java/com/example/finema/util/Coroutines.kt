package com.example.finema.util

import com.example.finema.models.movieResponse.Movie
import com.example.finema.models.movieResponse.MovieDetails
import com.example.finema.models.movieResponse.MovieResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

object Coroutines {

    fun<T> ioThenMan(work: suspend (() -> T?), callback: ((T?)->Unit)) =
        CoroutineScope(Dispatchers.Main).launch {
            val data = CoroutineScope(Dispatchers.IO).async  rt@{
                return@rt work()
            }.await()
            callback(data)
        }
}