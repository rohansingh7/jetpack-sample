package com.byjus.jetpack.paging

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber
import timber.log.Timber.DebugTree

@HiltAndroidApp
class PagingApp : Application() {

    override fun onCreate() {
        super.onCreate()
        Timber.plant(DebugTree())
    }
}