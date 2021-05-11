package com.example.finema.api.DimaVersion

import com.example.finema.api.MoviesApi
import com.example.finema.repositories.SafeApiRequest
import java.util.*

class MoviesRepository(
    private val api: MoviesApi
) : SafeApiRequest() {

    suspend fun getMovies(page: Int) = apiRequest {
        api.getMovies(page)
    }

    suspend fun getGenres() = apiRequest {
        api.getGenreList()
    }

    suspend fun getMovieDetails(id: Long) = apiRequest {
        api.getMovieDetails(id, Locale.getDefault().toString().replace('_', '-'))
    }

}