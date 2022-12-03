package com.hcdisat.musicapp.ui.main.models

data class TracksChartItem(
    val trackId: Int = 0,
    val artistId: Int,
    val artistName: String = "",
    val position: Int = 0,
    val title: String = "",
    val rank: Int = 0,
    val preview: String = "",
    val picture: String = ""
)

data class ArtistChartItem(
    val artistId: Int,
    val name: String = "",
    val picture: String = "",
    val position: Int = 0,
    val trackList: String = "",
)

data class AlbumChartItem(
    val albumId: Int,
    val artistId: Int,
    val cover: String,
    val position: Int,
    val title: String,
)