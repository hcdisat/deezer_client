package com.hcdisat.musicapp.data.network.repositories

import okhttp3.ResponseBody

data class ApiException(
    val code: Int,
    val errorMessage: String,
    val errorBody: ResponseBody?
) : Exception(errorMessage)