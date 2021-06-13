package com.example.finema.models.movieResponse

import com.google.gson.annotations.SerializedName

data class TrailersList(
    @SerializedName("results")
    val trailers: List<MovieTrailer>
)
