package com.example.slipapp.ui.theme

import android.annotation.SuppressLint
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = DarkCyan,
    primaryVariant = DarkerCyan,
    secondary = WhiteSmoke,
    background = Color.White,
    surface = DarkCyan,
    onPrimary = Color.White,
    onSecondary = DarkerCyan,
    onBackground = DarkCyan,
    onSurface = Color.White,
)

@SuppressLint("ConflictingOnColor")
private val LightColorPalette = lightColors(
    primary = DarkCyan,
    primaryVariant = DarkerCyan,
    secondary = WhiteSmoke,
    background =Color.White,
    surface = DarkCyan,
    onPrimary = Color.White,
    onSecondary = DarkerCyan,
    onBackground = DarkGray,
    onSurface = Color.White,
)

@Composable
fun SlipAppTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}