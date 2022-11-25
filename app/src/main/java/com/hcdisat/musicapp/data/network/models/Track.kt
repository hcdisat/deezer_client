package com.hcdisat.musicapp.data.network.models


import com.google.gson.annotations.SerializedName

data class Track(
    @SerializedName("album")
    val album: Album = Album(),
    @SerializedName("artist")
    val artist: Artist = Artist(),
    @SerializedName("duration")
    val duration: Int = 0,
    @SerializedName("explicit_content_cover")
    val explicitContentCover: Int = 0,
    @SerializedName("explicit_content_lyrics")
    val explicitContentLyrics: Int = 0,
    @SerializedName("explicit_lyrics")
    val explicitLyrics: Boolean = false,
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("link")
    val link: String = "",
    @SerializedName("md5_image")
    val md5Image: String = "",
    @SerializedName("position")
    val position: Int = 0,
    @SerializedName("preview")
    val preview: String = "",
    @SerializedName("rank")
    val rank: Int = 0,
    @SerializedName("title")
    val title: String = "",
    @SerializedName("title_short")
    val titleShort: String = "",
    @SerializedName("title_version")
    val titleVersion: String = "",
    @SerializedName("type")
    val type: String = ""
)