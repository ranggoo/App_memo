package com.john.episode

import android.app.Application
import com.john.episode.util.SecureSharedPreferences
import com.john.episode.util.SecureSharedPreferences.Companion.KEY_ACCESS_TOKEN
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber
import javax.inject.Inject

@HiltAndroidApp
class EpisodeApplication : Application() {

    @Inject lateinit var prefer: SecureSharedPreferences

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
            // prefer.put(KEY_ACCESS_TOKEN,"")
        }
    }
}