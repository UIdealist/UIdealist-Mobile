package com.helper.idealist.ui.topbars

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import com.helper.idealist.R
import com.helper.idealist.ui.theme.CustomTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuTopBar(
    onMenuClick: () -> Unit,
    actions : @Composable () -> Unit = {},
    title: @Composable () -> Unit = {}
) {
    CenterAlignedTopAppBar(
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = CustomTheme.colors.primary2,
            scrolledContainerColor = CustomTheme.colors.primary2,
            navigationIconContentColor = CustomTheme.colors.primary2,
            actionIconContentColor = CustomTheme.colors.primary1,
            titleContentColor = CustomTheme.colors.primary1,
        ),
        navigationIcon = {
            IconButton(
                onClick = onMenuClick,
                colors = IconButtonDefaults.iconButtonColors(
                    containerColor = CustomTheme.colors.primary2,
                    contentColor = CustomTheme.colors.primary1,
                    disabledContentColor = CustomTheme.colors.primary1,
                    disabledContainerColor = CustomTheme.colors.primary2,
                )
            ) {
                Icon(
                    modifier = Modifier
                        .fillMaxHeight()
                        .border(
                            width = CustomTheme.spaces.extraSmall,
                            color = CustomTheme.colors.primary1,
                            shape = RoundedCornerShape(20)
                        )
                        .padding(CustomTheme.spaces.medium),
                    imageVector = Icons.Filled.Menu,
                    contentDescription = stringResource(R.string.menu_icon_description),
                    tint = CustomTheme.colors.primary1
                )
            }
        },
        title = {
            title()
        },
        actions = {
            actions()
        }
    )
}