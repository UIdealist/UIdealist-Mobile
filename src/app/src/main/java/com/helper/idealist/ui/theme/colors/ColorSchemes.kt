package com.helper.idealist.ui.theme.colors

val LightThemeColors by lazy {
    CustomColors(
        primary1 = Purple500, primary2 = Purple90,
        primary3 = Orange500, primary4 = Orange90,
        secondary1 = Green500, secondary2 = Green90,
        secondary3 = Blue500, secondary4 = Blue90,
        tertiary1 = Red500, tertiary2 = Red90,
        tertiary3 = White500, tertiary4 = Black500,
        error1 = Red500, error2 = Red90,
        background1 = White500, background2 = Black500,
        textColor1 = Purple500, textColor2 = White500,
        textColor3 = Black500,
        colorMode = ColorMode.Light
    )
}

val DarkThemeColors by lazy {
    CustomColors(
        primary1 = Purple500, primary2 = Purple90,
        primary3 = Orange500, primary4 = Orange90,
        secondary1 = Green500, secondary2 = Green90,
        secondary3 = Blue500, secondary4 = Blue90,
        tertiary1 = Red500, tertiary2 = Red90,
        tertiary3 = White500, tertiary4 = White500,
        error1 = Red500, error2 = Red90,
        background1 = Black500, background2 = White500,
        textColor1 = Purple500, textColor2 = White500,
        textColor3 = Black500,
        colorMode = ColorMode.Dark
    )
}