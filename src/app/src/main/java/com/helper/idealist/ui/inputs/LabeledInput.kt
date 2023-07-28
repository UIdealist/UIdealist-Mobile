package com.helper.idealist.ui.inputs

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.helper.idealist.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LabeledInput(
    label : String,
    placeholder : String,
    stateVar : MutableState<String>,
    color : Color
) {
    Text(
        text = label,
        color = color,
        fontSize = 16.sp
    )
    TextField(
        value = stateVar.value,
        textStyle = TextStyle(
            color = color,
            fontSize = 16.sp
        ),
        placeholder = {
            Text(
                text = placeholder
            )
        },
        onValueChange = { newText : String ->
            stateVar.value = newText
        },
    )
    Spacer(modifier = Modifier.size(10.dp))
}