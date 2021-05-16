package com.example.finema.api

import androidx.lifecycle.LiveData
import androidx.paging.PagingData
import com.example.finema.models.GenreRequest.GenreList
import com.example.finema.models.movieResponse.Movie
import com.example.finema.models.movieResponse.MovieDetails
import com.example.finema.models.movieResponse.MovieResponse

interface IMoviesRepository{
    suspend fun getMovies(page: Int): MovieResponse

    suspend fun getGenres(): GenreList

    suspend fun getMoviesWithGenre(page: Int, with_genres: String): MovieResponse

    suspend fun getMovieDetails(id: Long): MovieDetails
}
