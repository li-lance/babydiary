package com.seraphim.core.ui.navigation

import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.snapshots.SnapshotStateList

val LocalBackStack = compositionLocalOf<SnapshotStateList<Any>> {
    error("No BackStack provided")
}