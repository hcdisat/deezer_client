package com.hcdisat.musicapp.artistchart.models

data class TracksChart(
    val id: Int = 0,
    val artistId: Int,
    val name: String = "",
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