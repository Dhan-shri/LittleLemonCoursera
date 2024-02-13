package com.example.littlelemon

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp

@Composable
fun SettingScreen() {
    Box (
        modifier = Modifier.fillMaxSize(),
    ) {
        // Scrollable GridLayout
        ScrollableGalleryScreen()
    }
}
