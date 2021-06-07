package com.example.finema.models.movieResponse

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class MovieResponseFromList(
    @SerializedName("items")
    var movies: List<Movie>
) : Parcelable
