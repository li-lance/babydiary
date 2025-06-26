package com.seraphim.babydiary

import android.app.Application
import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class BabyApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        Napier.base(DebugAntilog())
        startKoin {
            androidLogger()
            androidContext(this@BabyApplication)
//            modules(authModule + networkModule + sharedCommonModule + appModule)
        }
    }
}