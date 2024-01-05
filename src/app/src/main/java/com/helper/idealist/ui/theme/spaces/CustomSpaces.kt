package com.helper.idealist.ui.theme.spaces

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class CustomSpaces(
    val extraSmall: Dp = 2.dp,
    val small: Dp = 4.dp,
    val medium: Dp = 8.dp,
    val large: Dp = 16.dp,
    val extraLarge: Dp = 24.dp,

    val bigImageSize: Dp = 200.dp,
    val mediumImageSize: Dp = 100.dp,
    val smallImageSize: Dp = 50.dp,
)

val LocalCustomSpaces = staticCompositionLocalOf { CustomSpaces() }