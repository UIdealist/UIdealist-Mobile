package com.helper.idealist.ui.theme.typography

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

data class CustomTypography(
    val h1Cursive: TextStyle = TextStyle(
        fontFamily = FontFamily.Cursive,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center,
        fontSize = 55.sp
    ),
    val h2: TextStyle = TextStyle(
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center,
        fontSize = 45.sp
    ),
    val h3: TextStyle = TextStyle(
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center,
        fontSize = 35.sp
    ),
    val h4: TextStyle = TextStyle(
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.Normal,
        textAlign = TextAlign.Center,
        fontSize = 25.sp
    ),
    val body1: TextStyle = TextStyle(
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp,
    ),
)

val LocalCustomTypography = staticCompositionLocalOf { CustomTypography() }