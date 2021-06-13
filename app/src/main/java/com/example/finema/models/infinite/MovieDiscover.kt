package com.example.finema.models.infinite

import com.google.gson.annotations.SerializedName

data class MovieDiscover(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val results: List<MovieDiscoverResult>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)
