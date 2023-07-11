package com.helper.idealist.ui.inputs

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
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
        color = color
    )
    TextField(
        value = stateVar.value,
        placeholder = {
            Text(
                text = placeholder
            )
        },
        onValueChange = { newText : String ->
            stateVar.value = newText
        }
    )
}