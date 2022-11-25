package com.hcdisat.musicapp.data.network.models


import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

data class Tracks(
    @SerializedName("data")
    val data: List<Track> = listOf(),
    @SerializedName("total")
    val total: Int = 0
)