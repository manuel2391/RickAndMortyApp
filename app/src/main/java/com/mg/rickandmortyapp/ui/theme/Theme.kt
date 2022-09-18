package com.mg.rickandmortyapp.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = Green,
    primaryVariant = Green,
    secondary = Light,
    surface = Dark,
    background = Dark,
    onBackground = Light,
    onSurface = Light,
    onPrimary = Gray,
    onSecondary = Dark,
    error = Red,
    onError = Gray

)

private val LightColorPalette = DarkColorPalette

@Composable
fun RickAndMortyAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
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