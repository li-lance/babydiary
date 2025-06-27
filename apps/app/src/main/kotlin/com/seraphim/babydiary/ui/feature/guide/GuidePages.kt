package com.seraphim.babydiary.ui.feature.guide

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.seraphim.babydiary.ui.theme.Primary

@Composable
fun GuidePages(
    pageCount: Int = 5,
    onBack: () -> Unit = {}
) {
    val pagerState = rememberPagerState(pageCount = { pageCount })
//    val coroutineScope = rememberCoroutineScope()
    val currentPage = pagerState.currentPage

    Column {
        TopAppBar(
            title = {},
            navigationIcon = {
                IconButton(onClick = onBack) {
                    Icon(Icons.Filled.ArrowBackIosNew, contentDescription = "返回")
                }
            },
            actions = {
                Text(
                    modifier = Modifier.padding(horizontal = 16.dp),
                    text = "${currentPage + 1}/$pageCount",
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        )
        PagerIndicator(5, pagerState.currentPage)
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.weight(1f),
            verticalAlignment = Alignment.Top
        ) { page ->
            when (page) {
                0 -> RoleSwitchPages()
                1 -> UserEditPages()
                else -> Text(
                    text = "第 ${page + 1} 页",
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
            }

        }
    }
}

@Composable
fun PagerIndicator(pageCount: Int, currentPageIndex: Int, modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .padding(bottom = 8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            repeat(pageCount) { iteration ->
                val color = if (currentPageIndex == iteration) Primary else Color.LightGray
                Box(
                    modifier = modifier
                        .padding(2.dp)
                        .clip(RoundedCornerShape(50))
                        .background(color)
                        .size(width = 52.dp, height = 8.dp)
                )
            }
        }
    }
}