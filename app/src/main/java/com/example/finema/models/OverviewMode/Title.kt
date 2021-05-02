package com.cronocode.moviecatalog.models.OverviewMode

import com.google.gson.annotations.SerializedName

data class Title(
        @SerializedName("id") val id : String,
        @SerializedName("image") val image : Image,
        @SerializedName("runningTimeInMinutes") val runningTimeInMinutes : Int,
        @SerializedName("nextEpisode") val nextEpisode : String,
        @SerializedName("numberOfEpisodes") val numberOfEpisodes : Int,
        @SerializedName("seriesEndYear") val seriesEndYear : Int,
        @SerializedName("seriesStartYear") val seriesStartYear : Int,
        @SerializedName("title") val title : String,
        @SerializedName("titleType") val titleType : String,
        @SerializedName("year") val year : Int
)