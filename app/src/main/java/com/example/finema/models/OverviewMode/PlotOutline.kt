package com.cronocode.moviecatalog.models.OverviewMode

import com.google.gson.annotations.SerializedName

data class PlotOutline(
        @SerializedName("author") val author : String,
        @SerializedName("id") val id : String,
        @SerializedName("text") val text : String
)