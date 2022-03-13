package it.wakala.talkrepo.ui

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import it.wakala.talkrepo.BuildConfig
import timber.log.Timber

@HiltAndroidApp
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

}