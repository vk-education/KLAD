package com.example.finema.repositories

import com.example.finema.models.movieResponse.Movie


object Singleton {
    var signInAsGuest = false
    var allFilms = ArrayList<Movie>()
}