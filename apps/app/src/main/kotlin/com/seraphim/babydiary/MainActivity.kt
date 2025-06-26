package com.seraphim.babydiary

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import io.github.aakira.napier.Napier

class MainActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
//            val navController = rememberNavController()
        }
        Logger.e("MainActivity onCreate")
        Napier.e { "Napier MainActivity onCreate" }
    }
}