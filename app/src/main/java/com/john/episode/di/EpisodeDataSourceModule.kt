package com.john.episode.di

import com.john.episode.data.feed.EpisodeFeedDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object EpisodeDataSourceModule{
    @Provides
    @Singleton
    fun providesEpisodeFeeDataSource(
        retrofit: Retrofit
    ):EpisodeFeedDataSource = retrofit.create(EpisodeFeedDataSource::class.java)

}
