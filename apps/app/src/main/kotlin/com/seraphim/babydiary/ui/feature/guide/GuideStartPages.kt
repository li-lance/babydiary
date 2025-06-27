package com.seraphim.babydiary.ui.feature.guide

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.seraphim.babydiary.IS_FIRST_LAUNCH
import com.seraphim.babydiary.LocalBackStack
import com.seraphim.babydiary.domain.route.RouteMainTabs
import com.seraphim.core.mmkv.safeKvSave

@Composable
fun GuideStartPages() {
    val backStack = LocalBackStack.current
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp)
                )
                .padding(24.dp)
                .padding(bottom = 54.dp)
        ) {
            Text(
                text = "Peace of Mind For Busy Parents",
                style = MaterialTheme.typography.headlineLarge,
                color = MaterialTheme.colorScheme.primary
            )
            Text(
                modifier = Modifier.padding(top = 16.dp),
                text = "Ensuring a safe and happy experience for your children with Making parenting easier, one click at a time.",
                style = MaterialTheme.typography.bodyMedium
            )
            Button(
                onClick = {
                    false.safeKvSave(IS_FIRST_LAUNCH)
                    backStack.add(RouteMainTabs)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 32.dp),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text("Let’s Get Started")
                Icon(
                    imageVector = Icons.Filled.ArrowForward,
                    contentDescription = "进入",
                    modifier = Modifier.size(20.dp)
                )
            }

        }
    }
}