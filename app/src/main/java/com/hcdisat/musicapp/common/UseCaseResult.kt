package com.hcdisat.musicapp.common

sealed interface UseCaseResult {
    data class Success<out T>(val data: T) : UseCaseResult
    data class Failed<out T>(val throwable: Throwable, val data: T? = null) : UseCaseResult
}