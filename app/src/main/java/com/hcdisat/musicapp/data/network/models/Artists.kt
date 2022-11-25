package com.hcdisat.musicapp.data.network.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Artists(
    @SerialName("data")
    val `data`: List<Artist> = listOf(),
    @SerialName("total")
    val total: Int = 0
)