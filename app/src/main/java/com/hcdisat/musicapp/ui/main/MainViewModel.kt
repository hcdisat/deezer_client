package com.hcdisat.musicapp.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hcdisat.musicapp.common.UseCaseResult
import com.hcdisat.musicapp.ui.domain.factories.toAlbumChartItem
import com.hcdisat.musicapp.ui.domain.factories.toArtistChart
import com.hcdisat.musicapp.ui.domain.factories.toTracksChartItem
import com.hcdisat.musicapp.ui.domain.usecases.Charts
import com.hcdisat.musicapp.ui.domain.usecases.GetChartsUseCase
import com.hcdisat.musicapp.ui.models.ChartType
import com.hcdisat.musicapp.ui.models.ChartsUIState
import com.hcdisat.musicapp.ui.models.StateData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(getCharts: GetChartsUseCase) : ViewModel() {

    private val selectedChartFlow = MutableStateFlow(ChartType.ARTISTS)
    private val chartFlow = getCharts().map(::convertState)

    val uiState = selectedChartFlow.combine(chartFlow) { type, state ->
        when (state) {
            is ChartsUIState.Completed -> {
                ChartsUIState.Completed(state.data.copy(selectedChart = type))
            }
            else -> state
        }
    }.stateIn(viewModelScope, SharingStarted.Lazily, ChartsUIState.Loading)

    private fun convertState(result: UseCaseResult) = when (result) {
        is UseCaseResult.Failed<*> -> {
            ChartsUIState.Failed(result.throwable)
        }
        is UseCaseResult.Success<*> -> {
            val data = result.data as Charts
            ChartsUIState.Completed(
                StateData(
                    artistChart = data.artists.artists.map { it.toArtistChart() },
                    tracksChart = data.tracks.data.map { it.toTracksChartItem() },
                    albums = data.albums.data.map { it.toAlbumChartItem() }
                )
            )
        }
    }
}