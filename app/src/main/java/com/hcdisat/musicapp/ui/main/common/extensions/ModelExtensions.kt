package com.hcdisat.musicapp.ui.main.common.extensions

import com.hcdisat.musicapp.ui.main.models.ChartType


fun Int.toTab(): ChartType = when (this) {
    0 -> ChartType.ARTISTS
    1 -> ChartType.TRACKS
    2 -> ChartType.ALBUMS
    else -> ChartType.ARTISTS
}