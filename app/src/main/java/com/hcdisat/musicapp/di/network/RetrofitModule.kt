package com.hcdisat.musicapp.di.network

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import java.util.*
import java.util.concurrent.TimeUnit


@OptIn(ExperimentalSerializationApi::class)
class RetrofitModule {

    companion object {
        private const val REQUEST_TIMEOUT = 20L
        private const val BASE_URL = "https://api.deezer.com/"
    }

    fun providesRetrofit(httpClient: OkHttpClient, retrofitBuilder: Retrofit.Builder): Retrofit =
        retrofitBuilder.client(httpClient).build()

    fun providesRetrofitBuilder(): Retrofit.Builder =
        Retrofit.Builder()
            .addConverterFactory(
                Json.asConverterFactory("application/json".toMediaType())
            ).baseUrl(BASE_URL)

    fun providesOkHttpClient(interceptor: HttpLoggingInterceptor): OkHttpClient =
        OkHttpClient.Builder().addInterceptor(interceptor)
            .callTimeout(REQUEST_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(REQUEST_TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(REQUEST_TIMEOUT, TimeUnit.SECONDS).build()


    fun providesHttpLoggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
}