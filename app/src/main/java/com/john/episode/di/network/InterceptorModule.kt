package com.john.episode.di.network

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoSet
import okhttp3.Interceptor
import okhttp3.logging.HttpLoggingInterceptor

@InstallIn(SingletonComponent::class)
@Module
abstract class InterceptorModule {
    @Binds
    @IntoSet
    abstract fun bindEpisodeInterceptor(episodeInterceptor: EpisodeInterceptor): Interceptor

    @Binds
    @IntoSet
    abstract fun bindHttpLoggingInterceptor(httpClientFactory:HttpLoggingInterceptor):Interceptor
}