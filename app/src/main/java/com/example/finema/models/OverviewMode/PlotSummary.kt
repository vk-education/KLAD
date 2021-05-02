package com.cronocode.moviecatalog.models.OverviewMode

import com.google.gson.annotations.SerializedName

data class PlotSummary(
        @SerializedName("author") val author : String,
        @SerializedName("id") val id : String,
        @SerializedName("text") val text : String
)