package com.example.finema.api.DimaVersion

import com.example.finema.models.sub_model.GenreList
import com.example.finema.utlis.GENRE_LIST
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET(GENRE_LIST)
    fun getGenreList(): Call<GenreList>

}