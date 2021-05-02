package com.cronocode.moviecatalog.models.OverviewMode

import com.google.gson.annotations.SerializedName

data class Ratings(
        @SerializedName("canRate") val canRate : Boolean,
        @SerializedName("rating") val rating : Double,
        @SerializedName("ratingCount") val ratingCount : Int,
        @SerializedName("otherRanks") val otherRanks : List<OtherRanks>
)