package com.hcdisat.musicapp.data.network.models


import com.google.gson.annotations.SerializedName

data class Album(
    @SerializedName("cover")
    val cover: String = "",
    @SerializedName("cover_big")
    val coverBig: String = "",
    @SerializedName("cover_medium")
    val coverMedium: String = "",
    @SerializedName("cover_small")
    val coverSmall: String = "",
    @SerializedName("cover_xl")
    val coverXl: String = "",
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("artist")
    val artist: Artist = Artist(),
    @SerializedName("position")
    val position: Int = 0,
    @SerializedName("md5_image")
    val md5Image: String = "",
    @SerializedName("title")
    val title: String = "",
    @SerializedName("tracklist")
    val tracklist: String = "",
    @SerializedName("type")
    val type: String = ""
)