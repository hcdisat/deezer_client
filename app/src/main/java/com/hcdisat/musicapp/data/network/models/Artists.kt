package com.hcdisat.musicapp.data.network.models


import com.google.gson.annotations.SerializedName


data class Artists(
    @SerializedName("data")
    val artists: List<Artist> = listOf(),
    @SerializedName("total")
    val total: Int = 0
)