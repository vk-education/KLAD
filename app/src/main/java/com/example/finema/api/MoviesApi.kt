package com.example.finema.api

import com.example.finema.models.GenreRequest.GenreList
import com.example.finema.models.infinite.MovieDiscover
import com.example.finema.models.movieResponse.MovieDetails
import com.example.finema.models.movieResponse.MovieResponse
import com.example.finema.util.GENRE_LIST
import com.example.finema.util.TOP_RATED_LIST
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MoviesApi {

    @GET("movie/popular?api_key=bbf5a3000e95f1dddf266b5e187d4b21&language=ru-Ru")
    suspend fun getMovies(
        @Query("page") page: Int
    ): Response<MovieResponse>

    @GET(GENRE_LIST)
    suspend fun getGenreList(): Response<GenreList>

    @GET("movie/{movie_id}?api_key=bbf5a3000e95f1dddf266b5e187d4b21")
    suspend fun getMovieDetails(
        @Path("movie_id") id: Long,
        @Query("language") language: String
    ): Response<MovieDetails>

    @GET(TOP_RATED_LIST)
    suspend fun getMoviesWithGenre(
        @Query("page") page: Int,
        @Query("with_genres") with_genres: String
    ): Response<MovieResponse>

    @GET(DISCOVER)
    suspend fun everything(
        @Query("page") page: Int,
        @Query("query") query: String
        ): Response<MovieDiscover>

    companion object {
        operator fun invoke(): MoviesApi {
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
                .create(MoviesApi::class.java)
        }

        private const val BASE_URL = "https://api.themoviedb.org/3/"
        private const val GENRE_LIST =
            "genre/movie/list?api_key=bbf5a3000e95f1dddf266b5e187d4b21&language=ru-Ru"
        private const val TOP_RATED_LIST =
            "movie/top_rated?api_key=bbf5a3000e95f1dddf266b5e187d4b21&language=ru-Ru"
        private const val DISCOVER =
            "search/keyword?api_key=bbf5a3000e95f1dddf266b5e187d4b21"
    }
}
