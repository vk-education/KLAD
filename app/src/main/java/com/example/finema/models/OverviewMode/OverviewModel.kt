package com.example.finema.models.OverviewMode

import com.cronocode.moviecatalog.models.OverviewMode.*
import com.google.gson.annotations.SerializedName


data class OverviewModel(
        @SerializedName("id") val id : String,
        @SerializedName("title") val title : Title,
        @SerializedName("certificates") val certificates : Certificates,
        @SerializedName("ratings") val ratings : Ratings,
        @SerializedName("genres") val genres : List<String>,
        @SerializedName("releaseDate") val releaseDate : String,
        @SerializedName("plotOutline") val plotOutline : PlotOutline,
        @SerializedName("plotSummary") val plotSummary : PlotSummary
)