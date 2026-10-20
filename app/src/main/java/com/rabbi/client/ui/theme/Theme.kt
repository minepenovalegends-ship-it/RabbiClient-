package com.rabbi.client.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable

private val RabbiColorScheme = darkColorScheme(
    primary = RabbiPrimary,
    onPrimary = RabbiOnPrimary,
    primaryContainer = RabbiPrimaryContainer,
    onPrimaryContainer = RabbiOnPrimaryContainer,
    secondary = RabbiSecondary,
    background = RabbiBackground,
    onBackground = RabbiOnSurface,
    surface = RabbiSurface,
    onSurface = RabbiOnSurface,
    surfaceVariant = RabbiSurfaceVariant
)

@Composable
fun RabbiClientTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = RabbiColorScheme,
        typography = Typography,
        content = content
    )
}
