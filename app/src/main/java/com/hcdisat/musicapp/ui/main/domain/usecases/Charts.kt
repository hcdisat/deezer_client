package com.hcdisat.musicapp.ui.main.domain.usecases

import com.hcdisat.musicapp.data.network.models.Albums
import com.hcdisat.musicapp.data.network.models.Artists
import com.hcdisat.musicapp.data.network.models.Tracks

data class Charts(
    val artists: Artists,
    val tracks: Tracks,
    val albums: Albums
)
