package com.helper.idealist.ui.drawers

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.SnackbarData
import androidx.compose.material3.Text
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.helper.idealist.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuItem(
    icon: ImageVector,
    title: String,
    onClick: () -> Unit,
    iconDescription : String
) {
    NavigationDrawerItem(
        icon = {
            Icon(
                imageVector = icon,
                contentDescription = iconDescription
            )
        },
        label = {
            Text(
                text = title,
                fontSize = 16.sp
            )
        },
        selected = false,
        onClick = onClick
    )
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainMenuDrawer(
    onItemChange: (String) -> Unit,
) {
    ModalDrawerSheet {
        Column(
            modifier = Modifier
                .padding(PaddingValues(16.dp))
                .background(Color.White)
                .fillMaxWidth()
        ){
            Image(
                painter = painterResource(
                    id = R.drawable.default_profile_image
                ),
                contentDescription = stringResource(
                    id = R.string.menu_profile_image_description
                )
            )

            Spacer(modifier = Modifier.padding(16.dp))

            MenuItem(
                icon = Icons.Default.Favorite,
                title = stringResource(
                    id = R.string.menu_item_teams
                ),
                onClick = {
                    onItemChange("Teams")
                },
                iconDescription = stringResource(
                    id = R.string.menu_item_teams_description
                )
            )

            MenuItem(
                icon = Icons.Default.Favorite,
                title = stringResource(
                    id = R.string.menu_item_projects
                ),
                onClick = {
                    onItemChange("Projects")
                },
                iconDescription = stringResource(
                    id = R.string.menu_item_projects_description
                )
            )

            MenuItem(
                icon = Icons.Default.Favorite,
                title = stringResource(
                    id = R.string.menu_item_brainstorms
                ),
                onClick = {
                    onItemChange("Brainstorms")
                },
                iconDescription = stringResource(
                    id = R.string.menu_item_brainstorms_description
                )
            )

            MenuItem(
                icon = Icons.Default.Favorite,
                title = stringResource(
                    id = R.string.menu_item_ideas
                ),
                onClick = {
                    onItemChange("Ideas")
                },
                iconDescription = stringResource(
                    id = R.string.menu_item_ideas_description
                )
            )
        }
    }
}