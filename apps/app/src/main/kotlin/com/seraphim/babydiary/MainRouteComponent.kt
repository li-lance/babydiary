package com.seraphim.babydiary

import androidx.compose.runtime.Composable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.navigation3.runtime.entry
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.ui.NavDisplay
import com.seraphim.babydiary.domain.route.RouteGuide
import com.seraphim.babydiary.domain.route.RouteMain
import com.seraphim.babydiary.domain.route.RouteMainTabs
import com.seraphim.babydiary.ui.MainTabsSPages
import com.seraphim.babydiary.ui.feature.guide.GuideStartPages

@Composable
fun MainRouteComponent(backStack: SnapshotStateList<Any>) {

    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = entryProvider {
            entry<RouteMainTabs> { MainTabsSPages() }
            entry<RouteMain> { MainScreen() }
            entry<RouteGuide> { GuideStartPages() }
        })
}