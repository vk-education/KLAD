package com.example.finema.api

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.example.finema.repositories.SafeApiRequest
import com.example.finema.ui.chooseFavourite.MoviePagingSource
import java.util.Locale

class MoviesRepository(
    val api: MoviesApi
) : IMoviesRepository, SafeApiRequest() {

    override suspend fun getMovies(page: Int) = apiRequest {
        api.getMovies(page)
    }

    override suspend fun getGenres() = apiRequest {
        api.getGenreList()
    }

    override suspend fun getMoviesWithGenre(page: Int, with_genres: String) = apiRequest {
        api.getMoviesWithGenre(page, with_genres)
    }

    override suspend fun getMovieDetails(id: Long) = apiRequest {
        api.getMovieDetails(id, Locale.getDefault().toString().replace('_', '-'))
    }

    override suspend fun getMovieFromList(list_id: Int) = apiRequest {
        api.getMovieFromList(list_id)
    }

    override suspend fun getDiscoverMovies(query: String) =
        Pager(
            PagingConfig(
                pageSize = 20,
                maxSize = 100,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { MoviePagingSource(api, query) }
        ).flow
}
