package com.example.finema.api

import com.example.finema.repositories.SafeApiRequest
import java.util.Locale

class MoviesRepository(
    val api: MoviesApi
) : IMoviesRepository, SafeApiRequest {

    override suspend fun getMovies(page: Int) = apiRequest {
        api.getMovies(page)
    }

    override suspend fun getGenres() = apiRequest {
        api.getGenreList()
    }

    override suspend fun getMoviesWithGenre(page: Int, withGenres: String) = apiRequest {
        api.getMoviesWithGenre(page, withGenres)
    }

    override suspend fun getMovieDetails(id: Long) = apiRequest {
        api.getMovieDetails(id, Locale.getDefault().toString().replace('_', '-'))
    }

    override suspend fun getMovieFromList(listId: Int) = apiRequest {
        api.getMovieFromList(listId)
    }
}
