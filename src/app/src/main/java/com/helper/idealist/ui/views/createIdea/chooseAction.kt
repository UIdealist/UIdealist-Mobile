package com.helper.idealist.ui.views.createIdea

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import com.helper.idealist.R
import com.helper.idealist.ui.theme.CustomTheme

@Composable
fun CreateIdeaChooseAction(
    onDraw : () -> Unit,
    onWrite : () -> Unit,
    onRecordVideo : () -> Unit,
    onRecordAudio : () -> Unit,
    onTakePicture : () -> Unit
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(
            CustomTheme.spaces.extraLarge
        ),
        verticalArrangement = Arrangement.spacedBy(
            CustomTheme.spaces.large
        ),
        horizontalArrangement = Arrangement.spacedBy(
            CustomTheme.spaces.large
        )
    ) {
        item {
            CreateIdeaOption(
                icon = Icons.Default.Lock,
                text = stringResource(R.string.create_idea_action_draw),
                contentDescription = stringResource(R.string.lock_icon_description),
                direction = CreateIdeaOptionDirection.VERTICAL_ICON_FIRST,
                onClick = onDraw
            )
        }
        item {
            CreateIdeaOption(
                icon = Icons.Default.Edit,
                text = stringResource(R.string.create_idea_action_write),
                contentDescription = stringResource(R.string.edit_icon_description),
                direction = CreateIdeaOptionDirection.HORIZONTAL_ICON_FIRST,
                onClick = onWrite
            )
        }
        item {
            CreateIdeaOption(
                icon = Icons.Default.PlayArrow,
                text = stringResource(R.string.create_idea_action_record_video),
                contentDescription = stringResource(R.string.play_icon_description),
                direction = CreateIdeaOptionDirection.VERTICAL_ICON_FIRST,
                onClick = onRecordVideo
            )
        }
        item {
            CreateIdeaOption(
                icon = Icons.Default.ThumbUp,
                text = stringResource(R.string.create_idea_action_record_audio),
                contentDescription = stringResource(R.string.play_icon_description),
                direction = CreateIdeaOptionDirection.VERTICAL_TEXT_FIRST,
                onClick = onRecordAudio
            )
        }
        item {
            CreateIdeaOption(
                icon = Icons.Default.Person,
                text = stringResource(R.string.create_idea_action_take_picture),
                contentDescription = stringResource(R.string.person_icon_description),
                direction = CreateIdeaOptionDirection.HORIZONTAL_ICON_FIRST,
                onClick = onTakePicture
            )
        }
    }
}

internal enum class CreateIdeaOptionDirection {
    HORIZONTAL_ICON_FIRST,
    HORIZONTAL_TEXT_FIRST,
    VERTICAL_ICON_FIRST,
    VERTICAL_TEXT_FIRST
}

@Composable
internal fun CreateIdeaOption(
    icon: ImageVector,
    text: String,
    onClick : () -> Unit,
    contentDescription : String = "",
    direction: CreateIdeaOptionDirection = CreateIdeaOptionDirection.HORIZONTAL_ICON_FIRST,
) {
    val clickableModifier = Modifier
        .clickable(
            interactionSource = MutableInteractionSource(),
            indication = null,
            onClick = onClick
        )
        .border(
            width = CustomTheme.spaces.extraSmall,
            color = CustomTheme.colors.textColor1,
            shape = RoundedCornerShape(30)
        )
        .padding(
            CustomTheme.spaces.large
        )

    val textContent : @Composable () -> Unit = {
        Text(
            text = text,
            style = CustomTheme.typography.h4,
            color = CustomTheme.colors.textColor1
        )
    }

    val iconContent : @Composable () -> Unit = {
        Icon(
            modifier = Modifier
                .size(CustomTheme.spaces.smallImageSize),
            imageVector = icon,
            contentDescription = contentDescription,
            tint = CustomTheme.colors.textColor1
        )
    }

    when(direction) {
        CreateIdeaOptionDirection.HORIZONTAL_ICON_FIRST -> {
            Row(
                modifier = clickableModifier,
                verticalAlignment = Alignment.CenterVertically
            ) {
                iconContent()
                textContent()
            }
        }
        CreateIdeaOptionDirection.HORIZONTAL_TEXT_FIRST -> {
            Row(
                modifier = clickableModifier,
                verticalAlignment = Alignment.CenterVertically
            ) {
                textContent()
                iconContent()
            }
        }

        CreateIdeaOptionDirection.VERTICAL_ICON_FIRST -> {
            Column(
                modifier = clickableModifier,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                iconContent()
                textContent()
            }
        }

        CreateIdeaOptionDirection.VERTICAL_TEXT_FIRST -> {
            Column(
                modifier = clickableModifier,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                textContent()
                iconContent()
            }
        }
    }
}