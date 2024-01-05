package com.helper.idealist.ui.inputs

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.helper.idealist.ui.theme.CustomTheme

@Composable
fun LabeledInput(
    label : String,
    placeholder : String,
    stateVar : MutableState<String>,
    icon: ImageVector? = null,
    iconDescription : String = "",
    readOnly: Boolean = false,
    enabled : Boolean = true,
    singleLine : Boolean = true,
) {
    Column(
        modifier = Modifier
            .padding(CustomTheme.spaces.large)
    ) {
        Text(
            text = label,
            style = CustomTheme.typography.body1,
            modifier = Modifier
                .padding(0.dp)
                .background(
                    CustomTheme.colors.primary1,
                )
                .border(
                    width = CustomTheme.spaces.extraSmall,
                    color = CustomTheme.colors.primary1,
                    shape = RoundedCornerShape(
                        topStartPercent = 30,
                        topEndPercent = 30,
                    )
                )
            ,
            color = CustomTheme.colors.textColor2
        )
        Spacer(modifier = Modifier.size(CustomTheme.spaces.medium))
        Input(
            placeholder = placeholder,
            stateVar = stateVar,
            icon = icon,
            iconDescription = iconDescription,
            readOnly = readOnly,
            enabled = enabled,
            singleLine = singleLine,
        )
    }
}