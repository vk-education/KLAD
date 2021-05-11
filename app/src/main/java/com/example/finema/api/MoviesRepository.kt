package com.example.finema.api

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
    suspend fun getMoviesWithGenre(page: Int, with_genres: String) = apiRequest {
        api.getMoviesWithGenre(page, with_genres)
    }
    suspend fun getMovieDetails(id: Long) = apiRequest {
        api.getMovieDetails(id, Locale.getDefault().toString().replace('_', '-'))
    }

}