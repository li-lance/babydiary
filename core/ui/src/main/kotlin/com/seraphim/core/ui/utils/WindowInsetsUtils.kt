package com.seraphim.core.ui.utils

import android.app.Activity
import android.os.Build


fun Activity.navigationStatusBarTransparent(){
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
        window.isNavigationBarContrastEnforced = false
    }
}