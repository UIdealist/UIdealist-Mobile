package com.helper.idealist.ui.activities

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import com.helper.idealist.R
import com.helper.idealist.ui.drawers.MenuItem
import com.helper.idealist.ui.inputs.Input
import com.helper.idealist.ui.navigators.ScaffoldNavigatorDrawer
import com.helper.idealist.ui.theme.CustomTheme
import com.helper.idealist.ui.views.Brainstorms
import com.helper.idealist.ui.views.Ideas
import com.helper.idealist.ui.views.Projects
import com.helper.idealist.ui.views.Teams
import com.helper.idealist.ui.views.Home
@OptIn(ExperimentalMaterial3Api::class)
class MainMenuActivity : ThemedActivity() {

    @Composable
    override fun content() {

        // Generate items in navigation drawer
        val items = arrayOf(
            MenuItem(
                icon = Icons.Default.Person,
                iconDescription = stringResource(R.string.person_icon_description),
                title = stringResource(R.string.menu_profile_title),
                identifier = "Profile",
                content = { Home() }
            ),
            MenuItem(
                icon = Icons.Default.Star,
                iconDescription = stringResource(R.string.star_icon_description),
                title = stringResource(R.string.menu_ideas_title),
                identifier = "Ideas",
                content = { Ideas() }
            ),
            MenuItem(
                icon = Icons.Default.Check,
                iconDescription = stringResource(R.string.check_icon_description),
                title = stringResource(R.string.menu_teams_title),
                identifier = "Teams",
                content = { Teams() }
            ),
            MenuItem(
                icon = Icons.Default.Build,
                iconDescription = stringResource(R.string.check_icon_description),
                title = stringResource(R.string.menu_projects_title),
                identifier = "Projects",
                content = { Projects() }
            ),
            MenuItem(
                icon = Icons.Default.Favorite,
                iconDescription = stringResource(R.string.check_icon_description),
                title = stringResource(R.string.menu_investments_title),
                identifier = "Investments",
                content = { Brainstorms() }
            ),
            MenuItem(
                icon = Icons.Default.Call,
                iconDescription = stringResource(R.string.check_icon_description),
                title = stringResource(R.string.menu_invest_title),
                identifier = "Invest",
                content = { Brainstorms() }
            ),
            MenuItem(
                icon = Icons.Default.DateRange,
                iconDescription = stringResource(R.string.check_icon_description),
                title = stringResource(R.string.menu_calendar_title),
                identifier = "Calendar",
                content = { Brainstorms() }
            ),
            MenuItem(
                icon = Icons.Default.LocationOn,
                iconDescription = stringResource(R.string.check_icon_description),
                title = stringResource(R.string.menu_meeting_title),
                identifier = "Meeting",
                content = { Brainstorms() }
            ),
            MenuItem(
                icon = Icons.Default.PlayArrow,
                iconDescription = stringResource(R.string.check_icon_description),
                title = stringResource(R.string.menu_events_title),
                identifier = "Events",
                content = { Brainstorms() }
            ),
            MenuItem(
                icon = Icons.Default.List,
                iconDescription = stringResource(R.string.check_icon_description),
                title = stringResource(R.string.menu_chats_title),
                identifier = "Chat",
                content = { Brainstorms() }
            ),
            MenuItem(
                icon = Icons.Default.ExitToApp,
                iconDescription = stringResource(R.string.check_icon_description),
                title = stringResource(R.string.menu_logout_title),
                identifier = "Logout",
                content = { Brainstorms() }
            ),
        )

        val searchText = remember { mutableStateOf ("") }

        ScaffoldNavigatorDrawer(
            items = items,
            title = {
                Input(
                    placeholder = stringResource(R.string.menu_search_title),
                    stateVar = searchText,
                    icon = Icons.Default.Search,
                    iconDescription = stringResource(R.string.search_icon_description)
                )
            },
            actions = {
                Icon(
                    modifier = Modifier
                        .padding(
                            end = CustomTheme.spaces.medium,
                        )
                        .size(CustomTheme.spaces.smallImageSize),
                    painter = painterResource(R.drawable.person_icon),
                    contentDescription = stringResource(R.string.menu_icon_description),
                    tint = CustomTheme.colors.primary1
                )
            },
            content = {
                Home()
            },
        )
    }

}