package com.john.episode.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object EpisodeModule {
    @Provides
    @Singleton
    fun provideContext(application: Application): Context = application
}