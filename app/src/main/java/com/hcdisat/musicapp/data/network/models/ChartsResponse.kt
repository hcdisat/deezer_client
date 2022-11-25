package com.hcdisat.musicapp.data.network.models

import com.google.gson.annotations.SerializedName

data class ChartsResponse(
    @SerializedName("albums")
    val albums: Albums = Albums(),
    @SerializedName("tracks")
    val tracks: Tracks = Tracks(),
    @SerializedName("artists")
    val artists: Artists = Artists(),
)