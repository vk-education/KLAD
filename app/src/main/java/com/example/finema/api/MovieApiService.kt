package com.example.finema.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MovieApiService {

    companion object{
        private const val BASE_URL = "https://imdb8.p.rapidapi.com/"
        private const val BASE_URL_TMDB = "https://api.themoviedb.org/3/"
        private var retrofit : Retrofit? = null
        private val loggingInterceptor = HttpLoggingInterceptor()
        private val client = OkHttpClient.Builder().apply{
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            addInterceptor(loggingInterceptor)
        }.build()

        fun getInstance() : Retrofit {
            if(retrofit == null){
                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL_TMDB)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit!!
        }
    }
}