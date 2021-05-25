package com.example.finema.models.infinite

import com.google.gson.annotations.SerializedName

data class MovieDiscoverResult(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String
)
