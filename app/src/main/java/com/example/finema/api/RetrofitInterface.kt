package com.example.finema.api

import com.example.finema.models.sub_model.GenreList
import com.example.finema.utlis.GENRE_LIST
import com.example.movie.Model.MovieInfoModel
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface RetrofitInterface {
    @GET("movie/{movie_id}")
    fun getMovieDetails(@Path("movie_id") id : Int) : Single<MovieInfoModel>

}