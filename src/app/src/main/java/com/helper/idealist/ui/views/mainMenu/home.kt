package com.helper.idealist.ui.views.mainMenu

import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.helper.idealist.R
import com.helper.idealist.ui.activities.CreateIdeaActivity
import com.helper.idealist.ui.buttons.MainButton
import com.helper.idealist.ui.buttons.MainButtonType
import com.helper.idealist.ui.theme.CustomTheme

@Preview
@Composable
fun Home() {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        HomeItemContent {
            Text(
                text = stringResource(R.string.home_trending_title),
                color = CustomTheme.colors.textColor1
            )
        }
        HomeItemContent {
            Text(
                text = stringResource(R.string.home_suggested_ideas_title),
                color = CustomTheme.colors.textColor1
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    CustomTheme.colors.primary1
                )
                .weight(
                    1f, false
                ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            MainButton(
                text = stringResource(R.string.button_label_add_idea),
                onClick = {
                    context.startActivity(
                        Intent(
                            context,
                            CreateIdeaActivity::class.java
                        )
                    )
                },
                type = MainButtonType.Secondary
            )
        }
    }
}

@Composable
fun HomeItemContent(
    content: @Composable () -> Unit
) {
    Row(
        modifier = Modifier
            .padding(CustomTheme.spaces.medium)
            .fillMaxWidth()
            .border(
                width = CustomTheme.spaces.extraSmall,
                color = CustomTheme.colors.primary1,
                shape = RoundedCornerShape(
                    CustomTheme.spaces.medium
                )
            )
            .padding(CustomTheme.spaces.large)
    ) {
        content()
    }
}