package com.seraphim.babydiary.ui.feature.guide

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
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
import androidx.compose.ui.unit.dp

@Composable
fun GuidePages(
    pageCount: Int = 5,
    onBack: () -> Unit = {}
) {
    val pagerState = rememberPagerState(pageCount = { pageCount })
    val coroutineScope = rememberCoroutineScope()
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
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.weight(1f),
            verticalAlignment = Alignment.Top
        ) { page ->
            // 这里可以根据 page 展示不同内容
            Text(
                text = "第 ${page + 1} 页",
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }
    }
}