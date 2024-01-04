package com.helper.idealist.ui.buttons

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import com.helper.idealist.ui.theme.shapes.MainButtonShape
import com.helper.idealist.ui.theme.CustomTheme

enum class MainButtonType {
    Primary,
    Secondary,
    Tertiary,
    Quaternary,
}

@Composable
fun MainButton(
    text: String,
    onClick: () -> Unit,
    type : MainButtonType
){
    Button(
        onClick = onClick,
        modifier = Modifier
            .padding(CustomTheme.spaces.large),
        colors = ButtonDefaults.buttonColors(
            containerColor = when (type) {
                MainButtonType.Primary -> CustomTheme.colors.primary1
                MainButtonType.Secondary -> CustomTheme.colors.primary2
                MainButtonType.Tertiary -> CustomTheme.colors.primary3
                MainButtonType.Quaternary -> CustomTheme.colors.primary4
                else -> CustomTheme.colors.primary1
            }
        ),
        shape = CustomTheme.shapes.mainButtonShape
    ){
        Text(
            text = text,
            color = Color.White,
            fontSize = 4.em,
            modifier = Modifier
                .background(Color.Transparent)
        )
    }
}

@Preview
@Composable
fun MainButtonPreview() {
    CustomTheme {
        MainButton(
            text = "Button",
            onClick = {},
            type = MainButtonType.Primary
        )
    }
}