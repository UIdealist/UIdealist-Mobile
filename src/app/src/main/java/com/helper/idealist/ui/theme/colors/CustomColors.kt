package com.helper.idealist.ui.theme.colors

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

class CustomColors(
    primary1: Color,
    primary2: Color,
    primary3: Color,
    primary4: Color,
    secondary1: Color,
    secondary2: Color,
    secondary3: Color,
    secondary4: Color,
    tertiary1: Color,
    tertiary2: Color,
    tertiary3: Color,
    tertiary4: Color,
    error1: Color,
    error2: Color,
    colorMode: ColorMode,
) {
    var primary1 by mutableStateOf(primary1)
        private set

    var primary2 by mutableStateOf(primary2)
        private set

    var primary3 by mutableStateOf(primary3)
        private set

    var primary4 by mutableStateOf(primary4)
        private set

    var secondary1 by mutableStateOf(secondary1)
        private set

    var secondary2 by mutableStateOf(secondary2)
        private set

    var secondary3 by mutableStateOf(secondary3)
        private set

    var secondary4 by mutableStateOf(secondary4)
        private set

    var tertiary1 by mutableStateOf(tertiary1)
        private set

    var tertiary2 by mutableStateOf(tertiary2)
        private set

    var tertiary3 by mutableStateOf(tertiary3)
        private set

    var tertiary4 by mutableStateOf(tertiary4)
        private set

    var error1 by mutableStateOf(error1)
        private set

    var error2 by mutableStateOf(error2)
        private set

    var colorMode by mutableStateOf(colorMode)
        private set

    fun copy(
        primary1 : Color = this.primary1,
        primary2 : Color = this.primary2,
        primary3 : Color = this.primary3,
        primary4 : Color = this.primary4,
        secondary1 : Color = this.secondary1,
        secondary2 : Color = this.secondary2,
        secondary3 : Color = this.secondary3,
        secondary4 : Color = this.secondary4,
        tertiary1 : Color = this.tertiary1,
        tertiary2 : Color = this.tertiary2,
        tertiary3 : Color = this.tertiary3,
        tertiary4 : Color = this.tertiary4,
        error1 : Color = this.error1,
        error2 : Color = this.error2,
        colorMode : ColorMode = this.colorMode,
    ) = CustomColors(
        primary1 = primary1,
        primary2 = primary2,
        primary3 = primary3,
        primary4 = primary4,
        secondary1 = secondary1,
        secondary2 = secondary2,
        secondary3 = secondary3,
        secondary4 = secondary4,
        tertiary1 = tertiary1,
        tertiary2 = tertiary2,
        tertiary3 = tertiary3,
        tertiary4 = tertiary4,
        error1 = error1,
        error2 = error2,
        colorMode = colorMode
    )

    fun updateColorsFrom(other: CustomColors) {
        primary1 = other.primary1
        primary2 = other.primary2
        primary3 = other.primary3
        primary4 = other.primary4
        secondary1 = other.secondary1
        secondary2 = other.secondary2
        secondary3 = other.secondary3
        secondary4 = other.secondary4
        tertiary1 = other.tertiary1
        tertiary2 = other.tertiary2
        tertiary3 = other.tertiary3
        tertiary4 = other.tertiary4
        error1 = other.error1
        error2 = other.error2
        colorMode = other.colorMode
    }
}

val LocalCustomColors = staticCompositionLocalOf<CustomColors> { LightThemeColors }