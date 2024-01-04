package com.helper.idealist.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import com.helper.idealist.ui.theme.colors.CustomColors
import com.helper.idealist.ui.theme.colors.LocalCustomColors
import com.helper.idealist.ui.theme.shapes.CustomShapes
import com.helper.idealist.ui.theme.shapes.LocalCustomShapes
import com.helper.idealist.ui.theme.spaces.CustomSpaces
import com.helper.idealist.ui.theme.spaces.LocalCustomSpaces
import com.helper.idealist.ui.theme.typography.CustomTypography
import com.helper.idealist.ui.theme.typography.LocalCustomTypography

object CustomTheme {
    val colors: CustomColors
        @Composable
        @ReadOnlyComposable
        get() = LocalCustomColors.current

    val typography: CustomTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalCustomTypography.current

    val spaces: CustomSpaces
        @Composable
        @ReadOnlyComposable
        get() = LocalCustomSpaces.current

    val shapes: CustomShapes
        @Composable
        @ReadOnlyComposable
        get() = LocalCustomShapes.current

}