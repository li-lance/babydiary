package com.seraphim.babydiary.ui.feature.guide

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.border

@Composable
fun RoleSwitchPages() {
    var selectedIndex by remember { mutableIntStateOf(0) }
    Column {
        Text(
            modifier = Modifier.padding(horizontal = 16.dp),
            text = "What bring you \nto our a app?",
            style = MaterialTheme.typography.headlineLarge
        )
        Column(
            modifier = Modifier.fillMaxWidth().padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            RoleCard(
                title = "I am parent",
                desc = "I want to find a person who can take care of my baby when I am not at home",
                selected = selectedIndex == 0,
                onClick = { selectedIndex = 0 }
            )
            RoleCard(
                title = "I am k baby sitter",
                desc = "I love kids and I want to help people take care of them",
                selected = selectedIndex == 1,
                onClick = { selectedIndex = 1 }
            )
        }
    }
}

@Composable
fun RoleCard(title: String, desc: String, selected: Boolean, onClick: () -> Unit) {
    val borderColor = if (selected) MaterialTheme.colorScheme.primary else Color.LightGray
    val contentColor = if (selected) MaterialTheme.colorScheme.primary else Color.Black
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(Color.White, RoundedCornerShape(16.dp))
            .border(width = 2.dp, color = borderColor, shape = RoundedCornerShape(16.dp))
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Column(modifier = Modifier.fillMaxWidth().padding(16.dp)) {
            Text(text =title,
                style = MaterialTheme.typography.headlineSmall
            )
            Text(text = desc,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}