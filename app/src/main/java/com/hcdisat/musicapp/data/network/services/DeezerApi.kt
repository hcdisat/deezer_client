package com.hcdisat.musicapp.data.network.services

import com.hcdisat.musicapp.data.network.models.ChartsResponse
import retrofit2.Response
import retrofit2.http.GET

interface DeezerApi {
    companion object {
        private const val PATH = "charts/"
    }

    @GET(PATH)
    suspend fun charts(): Response<ChartsResponse>
}