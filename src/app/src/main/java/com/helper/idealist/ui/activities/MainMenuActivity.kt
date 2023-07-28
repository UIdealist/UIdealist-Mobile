package com.helper.idealist.ui.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.material.*
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.helper.idealist.ui.drawers.MainMenuDrawer
import com.helper.idealist.ui.topbars.MainMenuTopBar
import com.helper.idealist.ui.views.Brainstorms
import com.helper.idealist.ui.views.Ideas
import com.helper.idealist.ui.views.Projects
import com.helper.idealist.ui.views.Teams
import kotlinx.coroutines.launch

class MainMenuActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val drawerState = rememberDrawerState(DrawerValue.Closed)
            val scope = rememberCoroutineScope()
            val selectedItem = remember { mutableStateOf("") }

            Scaffold(
                topBar = {
                    MainMenuTopBar(
                        onMenuClick = {
                            scope.launch {
                                if (drawerState.isOpen) {
                                    drawerState.close()
                                } else {
                                    drawerState.open()
                                }
                            }
                        }
                    )
                },
                content = {
                    ModalNavigationDrawer(
                        drawerState = drawerState,
                        modifier = Modifier
                            .padding(it)
                            .background(Color.Black),
                        drawerContent = {
                            MainMenuDrawer(
                                onItemChange = { selection : String ->
                                    println("Selected item: $selection")
                                    selectedItem.value = selection
                                    scope.launch {
                                        drawerState.close()
                                    }
                                }
                            )
                        },
                        content = {
                            when (selectedItem.value) {
                                "Teams" -> {
                                    Teams()
                                }
                                "Projects" -> {
                                    Projects()
                                }
                                "Brainstorms" -> {
                                    Brainstorms()
                                }
                                "Ideas" -> {
                                    Ideas()
                                }
                                else -> {
                                    Text(text = "Home")
                                }
                            }
                        }
                    )
                }
            )

        }
    }
}