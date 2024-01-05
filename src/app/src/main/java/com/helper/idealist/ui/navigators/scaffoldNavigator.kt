package com.helper.idealist.ui.navigators

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.graphics.Color
import com.helper.idealist.ui.drawers.MainMenuDrawer
import com.helper.idealist.ui.theme.CustomTheme
import com.helper.idealist.ui.topbars.MenuTopBar
import com.helper.idealist.ui.drawers.MenuItem
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldNavigatorDrawer(
    items: Array<MenuItem>,
    actions : @Composable () -> Unit = {},
    title : @Composable () -> Unit = {},

    // Default content to display when no menu item is selected
    content: @Composable () -> Unit
){
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val selectedItem = remember { mutableStateOf<MenuItem?>(null) }

    Scaffold(
        topBar = {
            MenuTopBar(
                onMenuClick = {
                    scope.launch {
                        if (drawerState.isOpen) {
                            drawerState.close()
                        } else {
                            drawerState.open()
                        }
                    }
                },
                actions = actions,
                title = title
            )
        },
        content = {
            ModalNavigationDrawer(
                drawerState = drawerState,
                modifier = androidx.compose.ui.Modifier
                    .padding(it)
                    .background(CustomTheme.colors.primary2),
                scrimColor = Color.Transparent,
                drawerContent = {
                    MainMenuDrawer(
                        items = items,
                        onItemChange = { selection : MenuItem ->
                            selectedItem.value = selection
                            scope.launch {
                                drawerState.close()
                            }
                        },
                        selected = selectedItem.value
                    )
                },
                content = {
                    if (selectedItem.value != null) selectedItem.value!!.content() else content()
                }
            )
        }
    )
}
