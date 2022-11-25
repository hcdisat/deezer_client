package com.hcdisat.musicapp.data.network.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Albums(
    @SerialName("data")
    val `data`: List<Album> = listOf(),
    @SerialName("total")
    val total: Int = 0
)