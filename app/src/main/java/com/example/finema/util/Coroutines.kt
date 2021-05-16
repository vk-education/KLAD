package com.example.finema.util

import com.example.finema.models.movieResponse.Movie
import com.example.finema.models.movieResponse.MovieDetails
import com.example.finema.models.movieResponse.MovieResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

object Coroutines {

    private val dataSet = ArrayList<Movie>()
    private lateinit var resp: MovieResponse
    private lateinit var movie: MovieDetails

    fun ioThenMain(work: suspend (() -> MovieResponse?),
                   callback: ((MovieResponse?)->Unit),
                    call: ((MovieResponse?)->Unit),
                    flag: Boolean) =
        CoroutineScope(Dispatchers.Main).launch {
            if(flag){
                dataSet.clear()
            }
            val data = CoroutineScope(Dispatchers.IO).async  rt@{
                return@rt work()
            }.await()
            data?.movies.let {
                data?.movies = it?.shuffled()!!
            }
            dataSet.addAll(data!!.movies)
            resp = MovieResponse(dataSet)
            callback(resp)
            call(resp)
        }


    fun<T> ioThenMan(work: suspend (() -> T?), callback: ((T?)->Unit)) =
        CoroutineScope(Dispatchers.Main).launch {
            val data = CoroutineScope(Dispatchers.IO).async  rt@{
                return@rt work()
            }.await()
            callback(data)
        }

//    fun movieDetailsThenMain(work: suspend (() -> MovieDetails?), callback: ((MovieDetails?)->Unit)) =
//        CoroutineScope(Dispatchers.Main).launch {
//            val data = CoroutineScope(Dispatchers.IO).async  rt@{
//                return@rt work()
//            }.await()
//            data?.let {
//                movie = it
//            }
//            callback(movie)
//        }
}