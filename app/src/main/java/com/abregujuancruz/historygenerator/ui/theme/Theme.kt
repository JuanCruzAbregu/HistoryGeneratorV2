package com.abregujuancruz.historygenerator.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val ColorPalette = lightColors(
    primary = Red,
    primaryVariant = Teal500,
    secondary = Teal200
)

@Composable
fun HistoryDesignTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colors = ColorPalette,
        typography = HGTypography,
        shapes = Shapes,
        content = content
    )
}