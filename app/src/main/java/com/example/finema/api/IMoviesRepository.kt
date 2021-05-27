package com.example.finema.api

import com.example.finema.models.GenreRequest.GenreList
import com.example.finema.models.movieResponse.MovieDetails
import com.example.finema.models.movieResponse.MovieResponse
import com.example.finema.models.movieResponse.MovieResponseFromList

interface IMoviesRepository{
    suspend fun getMovies(page: Int): MovieResponse

    suspend fun getGenres(): GenreList

    suspend fun getMoviesWithGenre(page: Int, with_genres: String): MovieResponse

    suspend fun getMovieDetails(id: Long): MovieDetails

    suspend fun getMovieFromList(list_id: Int): MovieResponseFromList
}
