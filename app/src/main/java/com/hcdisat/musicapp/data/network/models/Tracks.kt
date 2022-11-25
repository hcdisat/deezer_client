package com.hcdisat.musicapp.data.network.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Tracks(
    @SerialName("data")
    val data: List<Track> = listOf(),
    @SerialName("total")
    val total: Int = 0
)