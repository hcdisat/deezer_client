package com.hcdisat.musicapp.ui.main.models

data class StateData(
    val artistChart: List<ArtistChartItem>,
    val tracksChart: List<TracksChartItem>,
    val albums: List<AlbumChartItem>,
    val selectedChart: ChartType = ChartType.ARTISTS,
)

enum class ChartType { ARTISTS, TRACKS, ALBUMS }

sealed interface ChartsUIState {
    object Loading : ChartsUIState
    data class Completed(val data: StateData) : ChartsUIState
    data class Failed(val throwable: Throwable) : ChartsUIState
}
