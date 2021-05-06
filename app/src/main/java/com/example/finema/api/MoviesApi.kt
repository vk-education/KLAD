package com.example.finema.api

import com.example.finema.models.MovieResponse
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesApi {

    @GET("movie/popular?api_key=bbf5a3000e95f1dddf266b5e187d4b21")
    suspend fun getMovies(
            @Query("page") page: Int
    ) : Response<MovieResponse>

    companion object{
        operator fun invoke() : MoviesApi {
            return Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl("https://api.themoviedb.org/3/")
                    .build()
                    .create(MoviesApi::class.java)
        }
    }

}