package com.helper.idealist.ui.buttons

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import com.helper.idealist.ui.shapes.MainButtonShape
import com.helper.idealist.ui.theme.*

@Composable
fun MainButton(
    text: String,
    onClick: () -> Unit,
    type : Int
){
    Button(
        onClick = onClick,
        modifier = Modifier
            .padding(16.dp)
            .rotate(
                // Randomly rotate the button
                (-30..30).random().toFloat()
            ),
        colors = ButtonDefaults.buttonColors(
            containerColor = when (type) {
                0 -> Primary1
                1 -> Primary2
                3 -> Primary3
                4 -> Primary4
                else -> Primary1
            }
        ),
        shape = MainButtonShape(type)
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