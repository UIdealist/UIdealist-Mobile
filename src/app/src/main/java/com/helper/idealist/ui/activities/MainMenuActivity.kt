package com.helper.idealist.ui.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.icons.Icons
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.material.*
import com.helper.idealist.ui.drawers.MainMenuDrawer
import com.helper.idealist.ui.topbars.MainMenuTopBar

class MainMenuActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val scaffoldState = rememberScaffoldState()

            Scaffold(
                topBar = {
                    MainMenuTopBar(
                        {
                            println("Menu Clicked")
                        }
                    )
                },
                drawerContent = {
                    MainMenuDrawer()
                }
            ) {
                Column {
                    Text(
                        text = "Idealist Body",
                        fontSize = 20.sp
                    )
                }
            }
        }
    }
}