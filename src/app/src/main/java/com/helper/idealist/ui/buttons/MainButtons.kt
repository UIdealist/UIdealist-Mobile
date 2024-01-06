package com.helper.idealist.ui.buttons

import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
}

@Composable
fun MainButton(
    text: String,
    onClick: () -> Unit,
    type : MainButtonType
){
    val borderColor = when (type) {
        MainButtonType.Primary -> CustomTheme.colors.primary1
        MainButtonType.Secondary -> CustomTheme.colors.primary1
    }
    val backgroundColor = when (type) {
        MainButtonType.Primary -> CustomTheme.colors.primary1
        MainButtonType.Secondary -> CustomTheme.colors.primary2
    }
    val textColor = when (type) {
        MainButtonType.Primary -> CustomTheme.colors.textColor2
        MainButtonType.Secondary -> CustomTheme.colors.textColor1
    }

    Button(
        onClick = onClick,
        modifier = Modifier
            .padding(CustomTheme.spaces.large)
            .border(
                width = CustomTheme.spaces.small,
                color = borderColor,
                shape = CustomTheme.shapes.mainButtonShape
            ),
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor,
        ),
        shape = CustomTheme.shapes.mainButtonShape
    ){
        Text(
            text = text,
            style = CustomTheme.typography.body1,
            color = textColor
        )
    }
}

@Preview
@Composable
internal fun MainButtonPreview() {
    CustomTheme {
        MainButton(
            text = "Button",
            onClick = {},
            type = MainButtonType.Secondary
        )
    }
}