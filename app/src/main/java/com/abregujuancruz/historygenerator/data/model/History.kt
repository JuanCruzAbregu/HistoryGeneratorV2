package com.abregujuancruz.historygenerator.data.model

import com.google.gson.annotations.SerializedName

data class History(
    @SerializedName("label") val label : String,
    @SerializedName("data")    val data : List<String>
)