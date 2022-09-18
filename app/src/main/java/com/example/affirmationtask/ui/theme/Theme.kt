package com.example.affirmationtask.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun TAOTheme(
    content: @Composable () -> Unit
) {
    val colors = lightColorPalette

    MaterialTheme(
        colors = colors,
        typography = typography,
        shapes = Shapes,
        content = content
    )
}
