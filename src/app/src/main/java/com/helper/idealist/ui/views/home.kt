package com.helper.idealist.ui.views

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.helper.idealist.R
import com.helper.idealist.ui.theme.CustomTheme

@Preview
@Composable
fun Home() {
    Column {
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