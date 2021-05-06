package com.example.finema.newapi

import com.example.finema.api.MoviesApi
import com.example.finema.repositories.SafeApiRequest

class MoviesRepository(
    private val api: MoviesApi
) : SafeApiRequest() {

    suspend fun getMovies(page: Int) = apiRequest {
        api.getMovies(page)
    }

}