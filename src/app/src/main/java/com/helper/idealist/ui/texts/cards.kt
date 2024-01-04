package com.helper.idealist.ui.texts

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.helper.idealist.ui.theme.CustomTheme

@Composable
fun TextCard(text : String){
    Text(
        modifier = Modifier
            .background(CustomTheme.colors.primary2)
            .border(
                width = CustomTheme.spaces.small,
                color = CustomTheme.colors.textColor1,
                shape = RoundedCornerShape(CustomTheme.spaces.medium)
            )
            .padding(CustomTheme.spaces.large),
        text = text,
        color = CustomTheme.colors.textColor1,
        style = CustomTheme.typography.body1
    )
}