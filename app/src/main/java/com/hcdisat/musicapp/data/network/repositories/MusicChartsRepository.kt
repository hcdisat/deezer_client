package com.hcdisat.musicapp.data.network.repositories

import com.hcdisat.musicapp.data.network.models.ChartsResponse
import com.hcdisat.musicapp.data.network.services.DeezerApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response
import javax.inject.Inject

interface MusicChartsRepository {
    fun getCharts(): Flow<HttpResult>
}

class MusicChartsRepositoryImpl @Inject constructor(
    private val deezerApi: DeezerApi
) : MusicChartsRepository {
    override fun getCharts(): Flow<HttpResult> = flow {
        val response = deezerApi.charts()
        if (!response.isSuccessful) {
            emit(buildHttpFailureResult(response))
        } else {
            response.body()?.let {
                emit(HttpResult.Completed(it))
            } ?: buildHttpFailureResult(response)
        }
    }

    private fun buildHttpFailureResult(response: Response<ChartsResponse>) =
        HttpResult.Failed(
            ApiException(
                code = response.code(),
                errorMessage = response.message(),
                errorBody = response.errorBody()
            )
        )
}