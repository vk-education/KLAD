package com.example.finema.models.movieResponse

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class MovieTrailer(
    @SerializedName("id")
    val id: String,

    @SerializedName("key")
    val key: String,

    @SerializedName("name")
    val name: String,

    @SerializedName("site")
    val site: String,

    @SerializedName("size")
    val size: Int,

    @SerializedName("type")
    val type: String
) : Parcelable