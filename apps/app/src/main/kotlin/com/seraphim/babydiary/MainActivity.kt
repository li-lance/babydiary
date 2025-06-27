package com.seraphim.babydiary

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import com.seraphim.babydiary.domain.route.RouteMain
import com.seraphim.babydiary.ui.theme.BabydiaryTheme
import com.seraphim.core.ui.utils.navigationStatusBarTransparent

val LocalBackStack = compositionLocalOf<SnapshotStateList<Any>> {
    error("No BackStack provided")
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        this.navigationStatusBarTransparent()
        super.onCreate(savedInstanceState)
        setContent {
            val backStack = remember { mutableStateListOf<Any>(RouteMain) }
            CompositionLocalProvider(LocalBackStack provides backStack) {
                MainRouteComponent(backStack)
                BabydiaryTheme {
                    backStack.add(RouteMain)
                }
            }
        }
    }
}