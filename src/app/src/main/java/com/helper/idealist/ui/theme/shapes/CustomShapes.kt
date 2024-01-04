package com.helper.idealist.ui.theme.shapes

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class CustomShapes(
    val mainButtonShape: Shape = MainButtonShape(),
    val secondaryButtonShape: Shape = CloudButtonShape(),
)

val LocalCustomShapes = staticCompositionLocalOf { CustomShapes() }