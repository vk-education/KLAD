package com.example.finema.api

import androidx.paging.PagingData
import com.example.finema.models.GenreRequest.GenreList
import com.example.finema.models.infinite.MovieDiscoverResult
import com.example.finema.models.movieResponse.MovieDetails
import com.example.finema.models.movieResponse.MovieResponse
import com.example.finema.models.movieResponse.MovieResponseFromList
import kotlinx.coroutines.flow.Flow

interface IMoviesRepository {
    suspend fun getMovies(page: Int): MovieResponse

    suspend fun getGenres(): GenreList

    suspend fun getMoviesWithGenre(page: Int, withGenres: String): MovieResponse

    suspend fun getMovieDetails(id: Long): MovieDetails

    suspend fun getDiscoverMovies(query: String):
        Flow<PagingData<MovieDiscoverResult>>

    suspend fun getMovieFromList(listId: Int): MovieResponseFromList
}
