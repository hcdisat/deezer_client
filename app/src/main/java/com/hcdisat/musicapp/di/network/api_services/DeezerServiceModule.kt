package com.hcdisat.musicapp.di.network.api_services

import com.hcdisat.musicapp.data.network.services.DeezerApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
class DeezerServiceModule {

    @Provides
    fun providesDeezerApi(retrofit: Retrofit): DeezerApi =
        retrofit.create(DeezerApi::class.java)
}