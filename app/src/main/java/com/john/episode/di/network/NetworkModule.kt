package com.john.episode.di.network

import com.john.episode.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Named
import javax.inject.Singleton


typealias EpisodeSet<T> = @JvmSuppressWildcards Set<T>

@InstallIn(SingletonComponent::class)
@Module
object NetworkModule {

    private const val NAME_EPISODE_BASE_URL = "NAME_EPISODE_BASE_URL"
    private const val EPISODE_BASE_URL = "http://3.34.117.184:9000/"

    @Provides
    @Named(NAME_EPISODE_BASE_URL)
    fun provideEpisodeUrl(): String = EPISODE_BASE_URL

    @Provides
    @Singleton
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            if (BuildConfig.DEBUG) {
                level = HttpLoggingInterceptor.Level.BODY
            }
        }
    }

    @Provides
    @Singleton
    fun provideBaseOkHttpClient(
        interceptors: EpisodeSet<Interceptor>
    ): OkHttpClient = OkHttpClient.Builder().apply {
        interceptors().addAll(interceptors)
    }.run {
        build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        @Named(NAME_EPISODE_BASE_URL) baseUrl: String
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(MoshiConverterFactory.create())
            .client(okHttpClient)
            .build()
    }
}