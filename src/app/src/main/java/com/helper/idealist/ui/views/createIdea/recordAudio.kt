package com.helper.idealist.ui.views.createIdea

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.helper.idealist.R
import com.helper.idealist.services.audio.record.MediaAudioRecorder
import com.helper.idealist.ui.theme.CustomTheme

@Composable
@Preview
fun RecordAudio() {
    val recording = remember { mutableStateOf(false) }
    val context = LocalContext.current
    val recordingService = MediaAudioRecorder(context)
    //recordingService.initService()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(CustomTheme.spaces.extraLarge),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = stringResource(R.string.create_idea_record_audio_announcement),
            style = CustomTheme.typography.h4,
            color = CustomTheme.colors.primary1,
            modifier = Modifier
                .padding(CustomTheme.spaces.large)
        )

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {

        }

        Column(
            modifier = Modifier
                .weight(1f, false),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            IconButton(
                onClick = {
                    recording.value = !recording.value
                },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(CustomTheme.spaces.large)
            ) {
                Icon(
                    imageVector = if (recording.value) {
                        Icons.Default.Warning
                    } else {
                        Icons.Default.PlayArrow
                    },
                    contentDescription = stringResource(R.string.audio_switch_icon_description),
                    tint = CustomTheme.colors.textColor1,
                    modifier = Modifier
                        .size(CustomTheme.spaces.smallImageSize)
                        .border(
                            width = CustomTheme.spaces.extraSmall,
                            color = CustomTheme.colors.primary1,
                            shape = RoundedCornerShape(30)
                        )
                )
            }
        }
    }

}