package com.helper.idealist.ui.texts

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp

@Composable
fun Title(text : String) {
    Text(
        text = text,
        color = Color.White,
        fontSize = 60.sp
    )
}

@Composable
fun SubTitle(text : String){
    Text(
        text = text,
        color = Color.White,
        fontSize = 30.sp
    )
}