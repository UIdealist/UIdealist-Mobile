package com.helper.idealist.ui.drawers

import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.SnackbarData
import androidx.compose.material3.Text
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.helper.idealist.R
import com.helper.idealist.ui.theme.*
import com.helper.idealist.ui.theme.CustomTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuItem(
    icon: ImageVector,
    title: String,
    onClick: () -> Unit,
    iconDescription : String,
    contentColor : Color
) {
    val selected = remember { mutableStateOf(false) }
    NavigationDrawerItem(
        modifier = Modifier
            .background(Color.Transparent),
        colors = NavigationDrawerItemDefaults.colors(
            selectedIconColor = Color.White,
            selectedTextColor = Color.White,
            unselectedIconColor = Color.White,
            unselectedTextColor = Color.White,
            selectedContainerColor = contentColor,
            unselectedContainerColor = contentColor
        ),
        icon = {
            Icon(
                imageVector = icon,
                contentDescription = iconDescription
            )
        },
        label = {
            Text(
                text = title,
                fontSize = 16.sp,
                color = Color.White
            )
        },
        selected = selected.value,
        onClick = {
            selected.value = true
            onClick()
        },
        shape = RoundedCornerShape(2.dp)
    )
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainMenuDrawer(
    onItemChange: (String) -> Unit,
) {
    ModalDrawerSheet (
        modifier = Modifier
            .background(Color.Gray),
        drawerContainerColor = Color.Gray,
        drawerContentColor = Color.Gray
    ){
        Column(
            modifier = Modifier
                .padding(PaddingValues(16.dp))
                .background(Color.Gray),
            horizontalAlignment = Alignment.CenterHorizontally

        ){
            Image(
                painter = painterResource(
                    id = R.drawable.defaultprofileimage
                ),
                contentDescription = stringResource(
                    id = R.string.menu_profile_image_description
                ),
                modifier = Modifier
                    .size(200.dp)
                    .clip(RoundedCornerShape(50))
                    .border(
                        width = 2.dp,
                        color = Color.White,
                        shape = RoundedCornerShape(50)
                    ),
                alignment = Alignment.Center
            )

            Spacer(modifier = Modifier.padding(16.dp))

            MenuItem(
                icon = Icons.Default.Person,
                title = stringResource(
                    id = R.string.menu_item_teams
                ),
                onClick = {
                    onItemChange("Teams")
                },
                iconDescription = stringResource(
                    id = R.string.menu_item_teams_description
                ),
                contentColor = CustomTheme.colors.primary1
            )

            MenuItem(
                icon = Icons.Default.Build,
                title = stringResource(
                    id = R.string.menu_item_projects
                ),
                onClick = {
                    onItemChange("Projects")
                },
                iconDescription = stringResource(
                    id = R.string.menu_item_projects_description
                ),
                contentColor = CustomTheme.colors.primary2
            )

            MenuItem(
                icon = Icons.Default.AccountBox,
                title = stringResource(
                    id = R.string.menu_item_brainstorms
                ),
                onClick = {
                    onItemChange("Brainstorms")
                },
                iconDescription = stringResource(
                    id = R.string.menu_item_brainstorms_description
                ),
                contentColor = CustomTheme.colors.primary3
            )

            MenuItem(
                icon = Icons.Default.AccountCircle,
                title = stringResource(
                    id = R.string.menu_item_ideas
                ),
                onClick = {
                    onItemChange("Ideas")
                },
                iconDescription = stringResource(
                    id = R.string.menu_item_ideas_description
                ),
                contentColor = CustomTheme.colors.primary4
            )

            Spacer(modifier = Modifier.padding(16.dp))

            MenuItem(
                icon = Icons.Default.ExitToApp,
                title = stringResource(
                    id = R.string.menu_item_exit
                ),
                onClick = {
                    // Return to previous screen
                    Toast.makeText(
                        null,
                        "Exit",
                        Toast.LENGTH_SHORT
                    ).show()
                },
                iconDescription = stringResource(
                    id = R.string.menu_item_ideas_description
                ),
                contentColor = Color.Black
            )
        }
    }
}