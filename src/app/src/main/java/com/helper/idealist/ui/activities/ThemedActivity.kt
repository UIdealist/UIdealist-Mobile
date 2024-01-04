package com.helper.idealist.ui.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.helper.idealist.ui.theme.CustomTheme

open class ThemedActivity(
    verticalAlign : Arrangement.Vertical = Arrangement.Center,
    horizontalAlign : Alignment.Horizontal = Alignment.CenterHorizontally
) : ComponentActivity() {

    private val verticalAlignment = verticalAlign
    private val horizontalAlignment = horizontalAlign

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            CustomTheme {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(CustomTheme.colors.background1),
                    verticalArrangement = verticalAlignment,
                    horizontalAlignment = horizontalAlignment
                ) {
                    content()
                }
            }

        }
    }

    @Composable
    open fun content() {
        // Will be overridden by child classes
    }
}