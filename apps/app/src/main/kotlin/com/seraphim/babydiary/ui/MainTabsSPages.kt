package com.seraphim.babydiary.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.seraphim.babydiary.R
import com.seraphim.babydiary.ui.feature.home.HomePages
import com.seraphim.babydiary.ui.feature.profile.ProfilePages

@Composable
fun MainTabsSPages() {
    var selectedIndex by remember { mutableIntStateOf(0) }
    Column {
        Box(modifier = Modifier.fillMaxWidth().weight(1f)) {
            // 根据选中的索引显示不同的页面,不使用路由
            when (selectedIndex) {
                0 -> HomePages()
//                1 -> SearchPages()
//                2 -> NotificationsPages()
                3 -> ProfilePages()
                else -> HomePages()
            }
        }
        NavigationBar {
            MainTabBarItem(
                selected = selectedIndex == 0,
                onClick = { selectedIndex = 0 },
                icon = {
                    Icon(
                        painter = painterResource(R.drawable.ic_tab_home),
                        contentDescription = "Home"
                    )
                },
                label = "Home"
            )
            MainTabBarItem(
                selected = selectedIndex == 1,
                onClick = { selectedIndex = 1 },
                icon = {
                    Icon(
                        painter = painterResource(R.drawable.ic_tab_message),
                        contentDescription = "Message"
                    )
                },
                label = "Message"
            )
            MainTabBarItem(
                selected = selectedIndex == 2,
                onClick = { selectedIndex = 2 },
                icon = {
                    Icon(
                        painter = painterResource(R.drawable.ic_tab_favorite),
                        contentDescription = "Favorites"
                    )
                },
                label = "Favorites"
            )
            MainTabBarItem(
                selected = selectedIndex == 3,
                onClick = { selectedIndex = 3 },
                icon = {
                    Icon(
                        painter = painterResource(R.drawable.ic_tab_profile),
                        contentDescription = "Profile"
                    )
                },
                label = "Profile"
            )
        }
    }
}

@Composable
fun RowScope.MainTabBarItem(
    selected: Boolean,
    onClick: () -> Unit,
    icon: @Composable () -> Unit,
    label: String
) {
    NavigationBarItem(
        selected = selected,
        onClick = onClick,
        icon = icon,
        label = { Text(label) },
        colors = NavigationBarItemDefaults.colors(
            selectedIconColor = if (selected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface,
            indicatorColor = Color.Transparent,
        )
    )
}