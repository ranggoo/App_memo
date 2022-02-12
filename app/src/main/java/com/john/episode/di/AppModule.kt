package com.john.episode.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.john.episode.util.SecureSharedPreferences
import com.john.episode.util.SecureSharedPreferences.Companion.getPreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
object AppModule {
    @Provides
    @Singleton
    fun provideContext(application: Application): Context = application

    @Provides
    @Singleton
    fun provideSharedPreference(context: Context): SecureSharedPreferences = SecureSharedPreferences.wrap(
        context.getPreferences(
            SecureSharedPreferences.PREFERENCE_ROSEMARY,
            0
        ), context
    )

}