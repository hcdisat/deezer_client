package com.hcdisat.musicapp.data.network.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Artist(
    @SerialName("id")
    val id: Int = 0,
    @SerialName("link")
    val link: String = "",
    @SerialName("name")
    val name: String = "",
    @SerialName("picture")
    val picture: String = "",
    @SerialName("picture_big")
    val pictureBig: String = "",
    @SerialName("picture_medium")
    val pictureMedium: String = "",
    @SerialName("picture_small")
    val pictureSmall: String = "",
    @SerialName("picture_xl")
    val pictureXl: String = "",
    @SerialName("position")
    val position: Int? = null,
    @SerialName("radio")
    val radio: Boolean = false,
    @SerialName("tracklist")
    val tracklist: String = "",
    @SerialName("type")
    val type: String = ""
)