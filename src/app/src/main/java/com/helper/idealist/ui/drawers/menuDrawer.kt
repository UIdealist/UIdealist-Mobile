package com.helper.idealist.ui.drawers

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.helper.idealist.R
import com.helper.idealist.ui.theme.*
import com.helper.idealist.ui.theme.CustomTheme

data class MenuItem(
    val icon: ImageVector,
    val iconDescription : String,
    val title: String,
    val identifier : String,
    val content : @Composable () -> Unit
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainMenuDrawer(
    items: Array<MenuItem>,
    onItemChange: (MenuItem) -> Unit,
    selected : MenuItem? = null,
) {
    ModalDrawerSheet (
        modifier = Modifier
            .background(CustomTheme.colors.primary2),
        drawerContainerColor = CustomTheme.colors.primary2,
        drawerContentColor = CustomTheme.colors.primary2,
    ){
        Column(
            modifier = Modifier
                .padding(PaddingValues(CustomTheme.spaces.medium)),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Image(
                painter = painterResource(R.drawable.defaultprofileimage),
                contentDescription = stringResource(R.string.menu_profile_image_description),
                modifier = Modifier
                    .size(CustomTheme.spaces.bigImageSize)
                    .clip(RoundedCornerShape(50))
                    .border(
                        width = CustomTheme.spaces.small,
                        color = CustomTheme.colors.background1,
                        shape = RoundedCornerShape(50)
                    ),
                alignment = Alignment.Center
            )

            Spacer(modifier = Modifier.padding(
                CustomTheme.spaces.medium
            ))

            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
            ) {
                items.forEach { item ->
                    NavigationDrawerItem(
                        modifier = Modifier
                            .background(Color.Transparent),
                        colors = NavigationDrawerItemDefaults.colors(
                            selectedIconColor = CustomTheme.colors.textColor2,
                            selectedTextColor = CustomTheme.colors.textColor2,
                            unselectedIconColor = CustomTheme.colors.textColor1,
                            unselectedTextColor = CustomTheme.colors.textColor1,
                            selectedContainerColor = CustomTheme.colors.primary1,
                            unselectedContainerColor = CustomTheme.colors.primary2
                        ),
                        icon = {
                            Icon(
                                imageVector = item.icon,
                                contentDescription = item.iconDescription
                            )
                        },
                        label = {
                            Text(
                                text = item.title,
                                style = CustomTheme.typography.body1,
                                color = when(selected?.identifier == item.identifier){
                                    true -> CustomTheme.colors.textColor2
                                    false -> CustomTheme.colors.textColor1
                                }
                            )
                        },
                        selected = selected?.identifier == item.identifier,
                        onClick = {
                            onItemChange(item)
                        },
                        shape = RoundedCornerShape(
                            CustomTheme.spaces.small
                        )
                    )
                    Spacer(modifier = Modifier.padding(
                        CustomTheme.spaces.medium
                    ))
                }
            }

        }
    }
}