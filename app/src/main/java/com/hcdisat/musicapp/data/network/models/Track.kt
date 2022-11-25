package com.hcdisat.musicapp.data.network.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Track(
    @SerialName("album")
    val album: Album = Album(),
    @SerialName("artist")
    val artist: Artist = Artist(),
    @SerialName("duration")
    val duration: Int = 0,
    @SerialName("explicit_content_cover")
    val explicitContentCover: Int = 0,
    @SerialName("explicit_content_lyrics")
    val explicitContentLyrics: Int = 0,
    @SerialName("explicit_lyrics")
    val explicitLyrics: Boolean = false,
    @SerialName("id")
    val id: Int = 0,
    @SerialName("link")
    val link: String = "",
    @SerialName("md5_image")
    val md5Image: String = "",
    @SerialName("position")
    val position: Int = 0,
    @SerialName("preview")
    val preview: String = "",
    @SerialName("rank")
    val rank: Int = 0,
    @SerialName("title")
    val title: String = "",
    @SerialName("title_short")
    val titleShort: String = "",
    @SerialName("title_version")
    val titleVersion: String = "",
    @SerialName("type")
    val type: String = ""
)