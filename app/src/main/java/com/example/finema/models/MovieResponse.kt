package com.example.finema.models

import com.example.finema.models.Movie
import com.google.gson.annotations.SerializedName

data class MovieResponse(
    @SerializedName("results")
    var movies : List<Movie>
)