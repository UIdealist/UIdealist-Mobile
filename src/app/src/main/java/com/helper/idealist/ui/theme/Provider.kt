package com.helper.idealist.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.runtime.staticCompositionLocalOf
import com.helper.idealist.ui.theme.colors.CustomColors

internal val LocalCustomColors = staticCompositionLocalOf<CustomColors> { error("No CustomColors provided") }

// Composable for custom provider
@Composable
fun ProvideCustomColors(
    colors: CustomColors,
    content: @Composable () -> Unit
) {
    val colorPalette = remember { colors }
    colorPalette.updateColorsFrom(colors)
    CompositionLocalProvider(LocalCustomColors provides colorPalette, content = content)
}