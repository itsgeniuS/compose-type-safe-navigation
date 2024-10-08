package com.example.composenavigation.typesafety

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.composenavigation.typesafety.core.TypeSafetyNavigation
import com.example.composenavigation.typesafety.res.ComposeNavigationTypeSafetyTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeNavigationTypeSafetyTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    TypeSafetyNavigation(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}
