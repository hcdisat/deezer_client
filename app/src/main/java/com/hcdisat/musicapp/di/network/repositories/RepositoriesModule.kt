package com.hcdisat.musicapp.di.network.repositories

import com.hcdisat.musicapp.data.network.repositories.MusicChartsRepository
import com.hcdisat.musicapp.data.network.repositories.MusicChartsRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoriesModule {

    @Binds
    abstract fun bindsMusicChartRepository(impl: MusicChartsRepositoryImpl): MusicChartsRepository
}