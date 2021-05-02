package com.example.finema.api

import com.example.finema.models.OverviewMode.OverviewModel
import com.example.finema.models.TMDBMovie
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RetrofitInterface {
    @GET("title/get-overview-details?currentCountry=US")
    fun getMovie(@Query("tconst") id: String
    ): Call<OverviewModel>

    @GET("movie/{movie_id}?")
    fun getMovieTMDB(@Path("movie_id") id: Int,
                     @Query("api_key") key: String
    ): Call<TMDBMovie>

}