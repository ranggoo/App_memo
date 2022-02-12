package com.john.episode.di.episode

import com.john.episode.data.feed.content.EpisodeFeedContentRepositoryImpl
import com.john.episode.domain.feed.EpisodeFeedContentRepository
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
    ): EpisodeFeedContentRepository
}