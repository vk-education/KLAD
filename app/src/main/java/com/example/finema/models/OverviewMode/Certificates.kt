package com.cronocode.moviecatalog.models.OverviewMode

import com.google.gson.annotations.SerializedName

data class Certificates (
        @SerializedName("US") val uS : List<US>
)