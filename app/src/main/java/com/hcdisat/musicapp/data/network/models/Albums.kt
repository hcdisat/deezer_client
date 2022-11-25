package com.hcdisat.musicapp.data.network.models


import com.google.gson.annotations.SerializedName

data class Albums(
    @SerializedName("data")
    val `data`: List<Album> = listOf(),
    @SerializedName("total")
    val total: Int = 0
)