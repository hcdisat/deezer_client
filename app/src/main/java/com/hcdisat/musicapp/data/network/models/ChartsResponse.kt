package com.hcdisat.musicapp.data.network.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ChartsResponse(
    @SerialName("albums")
    val albums: Albums = Albums(),
    @SerialName("tracks")
    val tracks: Tracks = Tracks(),
    @SerialName("artists")
    val artists: Artists = Artists(),
)