package com.hcdisat.musicapp.di.network.api_services

import retrofit2.Retrofit

class DeezerServiceModule {

    fun providesDeezerApi(retrofit: Retrofit): DeezerServiceModule =
        retrofit.create(DeezerServiceModule::class.java)
}