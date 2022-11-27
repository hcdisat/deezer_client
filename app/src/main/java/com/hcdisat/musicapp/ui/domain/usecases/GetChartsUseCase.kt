package com.hcdisat.musicapp.ui.domain.usecases

import com.hcdisat.musicapp.common.UseCaseResult
import com.hcdisat.musicapp.data.network.repositories.HttpResult
import com.hcdisat.musicapp.data.network.repositories.MusicChartsRepository
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@ViewModelScoped
class GetChartsUseCase @Inject constructor(
    private val chartsRepository: MusicChartsRepository
) {
    operator fun invoke(): Flow<UseCaseResult> = chartsRepository.getCharts().map { result ->
        when (result) {
            is HttpResult.Completed -> {
                UseCaseResult.Success(
                    Charts(
                        artists = result.chartsResponse.artists,
                        tracks = result.chartsResponse.tracks,
                        albums = result.chartsResponse.albums
                    )
                )
            }
            is HttpResult.Failed -> {
                UseCaseResult.Failed(result.throwable, null)
            }
        }
    }
}