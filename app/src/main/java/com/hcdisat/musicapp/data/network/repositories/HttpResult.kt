package com.hcdisat.musicapp.data.network.repositories

import com.hcdisat.musicapp.data.network.models.ChartsResponse

sealed class HttpResult {
    data class Completed(val chartsResponse: ChartsResponse) : HttpResult()
    data class Failed(val throwable: Throwable) : HttpResult()
}
