package com.seraphim.core.mmkv

import android.content.Context
import com.ctrip.flight.mmkv.initialize

fun initMMKV(context: Context) {
    val rootDir = initialize(context)
}