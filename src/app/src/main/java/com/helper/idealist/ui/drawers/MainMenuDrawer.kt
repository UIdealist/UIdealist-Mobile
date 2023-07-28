package com.helper.idealist.ui.drawers

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp

@Composable
fun MainMenuDrawer() {
    Column {
        Text(
            text = "Idealist",
            fontSize = 20.sp
        )
    }
}