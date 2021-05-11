package com.example.finema.models.movieResponse

import android.os.Parcelable
import com.example.finema.models.movieResponse.Movie
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class MovieResponse(
    @SerializedName("results")
    var movies : List<Movie>
) : Parcelable