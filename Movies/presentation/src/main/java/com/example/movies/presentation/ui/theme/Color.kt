package com.example.movies.presentation.ui.theme

import androidx.compose.material.lightColors
import androidx.compose.ui.graphics.Color


//https://maketintsandshades.com/#476810
/*1. Primary
2. Primary Variant
3. Secondary
4. Secondary Variant
5. Background
6. Surface
7. Error
8. On Primary
9. On Secondary
10. On Background
11. On Surface
12. On Error*/

val md_theme_light_primary = Color(0xFFf04f00)
val md_theme_light_primaryVariant = Color(0xFFc03f00)
val md_theme_light_background = Color(0xFF333333)
val md_theme_light_onPrimary = Color(0xFFFFFFFF)
val md_theme_light_onBackground = Color(0xFFFFFFFF)

val LightColorPalette = lightColors(
    primary = md_theme_light_primary,
    primaryVariant = md_theme_light_primaryVariant,
    onPrimary = md_theme_light_onPrimary,
    background = md_theme_light_background,
    onBackground = md_theme_light_onBackground,
)

// ..
// ..

/*
val md_theme_dark_primary = Color(0xFFACD370)
val md_theme_dark_onPrimary = Color(0xFF213600)
val md_theme_dark_primaryContainer = Color(0xFF324F00)*/