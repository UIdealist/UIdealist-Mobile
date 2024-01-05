package com.helper.idealist.ui.inputs

import androidx.compose.material3.Icon
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.helper.idealist.ui.theme.CustomTheme

@Composable
@Preview
@OptIn(ExperimentalMaterial3Api::class)
fun Input(
    placeholder : String = "",
    stateVar : MutableState<String> = mutableStateOf("test"),
    icon: ImageVector? = null,
    iconDescription : String = "",
    readOnly: Boolean = false,
    enabled : Boolean = true,
    singleLine : Boolean = true,
) {
    OutlinedTextField(
        modifier = Modifier
            .border(
                width = CustomTheme.spaces.extraSmall,
                color = CustomTheme.colors.primary1,
                shape = RoundedCornerShape(30),
            ),
        shape = RoundedCornerShape(30),
        value = stateVar.value,
        textStyle = CustomTheme.typography.body1.copy(
            color = CustomTheme.colors.textColor1
        ),
        placeholder = {
            Text(
                text = placeholder,
                style = CustomTheme.typography.body1,
                color = CustomTheme.colors.textColor1
            )
        },
        onValueChange = { newText : String ->
            stateVar.value = newText
        },
        readOnly = readOnly,
        enabled = enabled,
        trailingIcon = {
            if (icon != null) {
                Icon(
                    imageVector = icon,
                    contentDescription = iconDescription,
                    tint = CustomTheme.colors.primary1
                )
            }
        },
        singleLine = singleLine
    )

}