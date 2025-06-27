package com.seraphim.babydiary

import android.app.Application
import com.seraphim.core.mmkv.initMMKV
import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class BabyApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        Napier.base(DebugAntilog())
        initMMKV(this)
        startKoin {
            androidLogger()
            androidContext(this@BabyApplication)
//            modules(authModule + networkModule + sharedCommonModule + appModule)
        }
    }
}