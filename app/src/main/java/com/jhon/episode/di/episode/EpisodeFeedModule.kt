package com.jhon.episode.di.episode

import com.jhon.episode.data.feed.content.EpisodeFeedContentRepositoryImpl
import com.jhon.episode.domain.feed.EpisodeFeedContentRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@InstallIn(SingletonComponent::class)
@Module
abstract class EpisodeFeedModule {

    @Binds
    abstract fun bindsEpisodeFeedContentRepository(
        episodeFeedContentRepositoryImpl: EpisodeFeedContentRepositoryImpl
    ):EpisodeFeedContentRepository

}