package com.helper.idealist.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
import com.helper.idealist.ui.theme.colors.CustomColors
import com.helper.idealist.ui.theme.colors.LightThemeColors
import com.helper.idealist.ui.theme.colors.DarkThemeColors
import com.helper.idealist.ui.theme.colors.LocalCustomColors
import com.helper.idealist.ui.theme.shapes.CustomShapes
import com.helper.idealist.ui.theme.shapes.LocalCustomShapes
import com.helper.idealist.ui.theme.spaces.CustomSpaces
import com.helper.idealist.ui.theme.spaces.LocalCustomSpaces
import com.helper.idealist.ui.theme.typography.CustomTypography
import com.helper.idealist.ui.theme.typography.LocalCustomTypography

@Composable
fun CustomTheme(
    spaces: CustomSpaces = CustomTheme.spaces,
    typography: CustomTypography = CustomTheme.typography,
    shapes: CustomShapes = CustomTheme.shapes,
    colors: CustomColors = CustomTheme.colors,
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {

    val colors = if (darkTheme) DarkThemeColors else LightThemeColors

    CompositionLocalProvider(
        LocalCustomShapes provides shapes,
        LocalCustomSpaces provides spaces,
        LocalCustomTypography provides typography,
        LocalCustomColors provides colors,
    ) {
        content()
    }
}