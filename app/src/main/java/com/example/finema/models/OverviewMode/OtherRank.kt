package com.cronocode.moviecatalog.models.OverviewMode

import com.google.gson.annotations.SerializedName

data class OtherRanks (
        @SerializedName("id") val id : String,
        @SerializedName("label") val label : String,
        @SerializedName("rank") val rank : Int,
        @SerializedName("rankType") val rankType : String
)