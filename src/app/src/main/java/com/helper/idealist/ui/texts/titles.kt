package com.helper.idealist.ui.texts

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import com.helper.idealist.ui.theme.CustomTheme

@Composable
fun Title(text : String) {
    Text(
        text = text,
        style = CustomTheme.typography.h2,
        color = CustomTheme.colors.textColor1,
    )
}

@Composable
fun SubTitle(text : String){
    Text(
        text = text,
        style = CustomTheme.typography.h3,
        color = CustomTheme.colors.textColor1,
    )
}