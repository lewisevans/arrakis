package com.example.movies.presentation.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun MoviesTheme(
    /*darkTheme: Boolean = isSystemInDarkTheme(),*/ /*USE THIS FOR DARK MODE IF NEEDED*/
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colors = LightColorPalette,
        typography = LightTypography,
        content = content,
    )
}
