package com.seraphim.babydiary.ui.feature.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.seraphim.babydiary.R

@Composable
fun HomePages() {
    Column(
        modifier = Modifier.statusBarsPadding()
    ) {
        TopBar()
        HomeCarousel()
        ListTitle("Babysitters nearby") { }
        ListTitle("Top rated") { }

    }
}

@Composable
private fun TopBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Image(
            painter = rememberAsyncImagePainter("https://images.unsplash.com/photo-1506744038136-46273834b3fb"),
            contentDescription = "示例图片",
            modifier = Modifier
                .size(46.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 12.dp)
        ) {
            Text("Hi Lance", style = MaterialTheme.typography.headlineSmall)
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painter = painterResource(R.drawable.ic_location),
                    contentDescription = "地址图标",
                    modifier = Modifier.size(16.dp)
                )
                Text(
                    text = "The current location is unknown",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(start = 4.dp)
                )
            }
        }
        Icon(
            painter = painterResource(R.drawable.ic_notication),
            contentDescription = "通知图标",
            tint = MaterialTheme.colorScheme.primary,
            modifier = Modifier.size(24.dp)
        )
    }
}

@Composable
private fun HomeCarousel() {
    val images = listOf(
        "https://images.unsplash.com/photo-1506744038136-46273834b3fb",
        "https://images.unsplash.com/photo-1465101046530-73398c7f28ca",
        "https://images.unsplash.com/photo-1519125323398-675f0ddb6308"
    )
    val pagerState = rememberPagerState(pageCount = { images.size })
    val coroutineScope = rememberCoroutineScope()
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
                .wrapContentHeight(),
        ) { page ->
            Image(
                painter = rememberAsyncImagePainter(images[page]),
                contentDescription = "轮播图$page",
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(344f / 155f)
                    .clip(RoundedCornerShape(20.dp))
                    .background(Color.LightGray, RoundedCornerShape(20.dp)),
                contentScale = ContentScale.Crop
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            repeat(images.size) { index ->
                val color =
                    if (pagerState.currentPage == index) MaterialTheme.colorScheme.primary else Color.LightGray
                val width = if (pagerState.currentPage == index) 30.dp else 16.dp
                Box(
                    modifier = Modifier
                        .padding(4.dp)
                        .height(6.dp)
                        .background(color, RoundedCornerShape(4.dp))
                        .width(width)
                )
            }
        }
    }
}

@Composable
fun ListTitle(title: String, action: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 16.dp),
        verticalAlignment = Alignment.Bottom
    ) {
        Text(title, style = MaterialTheme.typography.titleMedium)
        Spacer(modifier = Modifier.weight(1f))
        Text(
            "See all",
            modifier = Modifier.clickable {
                action()
            },
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.primary
        )
    }
}