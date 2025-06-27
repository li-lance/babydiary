package com.seraphim.babydiary

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.seraphim.babydiary.domain.route.RouteGuide
import com.seraphim.babydiary.domain.route.RouteMainTabs
import com.seraphim.core.mmkv.safeKvGet

const val IS_FIRST_LAUNCH = "is_first_launch"

@Composable
fun MainScreen() {
    val backStack = LocalBackStack.current
    Scaffold { innerPadding ->
        innerPadding.calculateBottomPadding()
        if (safeKvGet(IS_FIRST_LAUNCH, true)) {
            backStack.add(RouteGuide)
        } else {
            backStack.add(RouteMainTabs)
        }

    }
}