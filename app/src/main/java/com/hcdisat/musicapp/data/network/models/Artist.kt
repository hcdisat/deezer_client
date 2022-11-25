package com.hcdisat.musicapp.data.network.models


import com.google.gson.annotations.SerializedName

data class Artist(
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("link")
    val link: String = "",
    @SerializedName("name")
    val name: String = "",
    @SerializedName("picture")
    val picture: String = "",
    @SerializedName("picture_big")
    val pictureBig: String = "",
    @SerializedName("picture_medium")
    val pictureMedium: String = "",
    @SerializedName("picture_small")
    val pictureSmall: String = "",
    @SerializedName("picture_xl")
    val pictureXl: String = "",
    @SerializedName("position")
    val position: Int? = null,
    @SerializedName("radio")
    val radio: Boolean = false,
    @SerializedName("tracklist")
    val tracklist: String = "",
    @SerializedName("type")
    val type: String = ""
)