package com.seraphim.babydiary

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.seraphim.babydiary.ui.feature.guide.GuidePages

@Composable
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
fun MainScreen() {
    Scaffold {
        GuidePages()
    }
}