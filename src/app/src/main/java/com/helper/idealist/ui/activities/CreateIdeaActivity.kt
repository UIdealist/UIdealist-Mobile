package com.helper.idealist.ui.activities

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.res.stringResource
import com.helper.idealist.R
import com.helper.idealist.ui.buttons.MainButton
import com.helper.idealist.ui.buttons.MainButtonType
import com.helper.idealist.ui.texts.Title
import com.helper.idealist.ui.views.createIdea.CreateIdeaChooseAction
import com.helper.idealist.ui.views.createIdea.RecordAudio

enum class CreateIdeaActivityState {
    CHOOSING_ACTION, DRAWING,
    WRITING, RECORDING_VIDEO,
    RECORDING_AUDIO, TAKING_PICTURE
}

class CreateIdeaActivity : ThemedActivity(){

    @Composable
    override fun content() {
        val currentAction = remember { mutableStateOf(CreateIdeaActivityState.CHOOSING_ACTION) }

        Title(
            text = stringResource(R.string.create_idea_title)
        )

        @Composable
        fun Back() {
            MainButton(
                text = stringResource(R.string.create_idea_return_button_text),
                onClick = {
                    currentAction.value = CreateIdeaActivityState.CHOOSING_ACTION
                },
                type = MainButtonType.Secondary
            )
        }

        when(currentAction.value) {
            CreateIdeaActivityState.CHOOSING_ACTION -> {
                CreateIdeaChooseAction(
                    onDraw = {
                        currentAction.value = CreateIdeaActivityState.DRAWING
                    },
                    onWrite = {
                        currentAction.value = CreateIdeaActivityState.WRITING
                    },
                    onRecordVideo = {
                        currentAction.value = CreateIdeaActivityState.RECORDING_VIDEO
                    },
                    onRecordAudio = {
                        currentAction.value = CreateIdeaActivityState.RECORDING_AUDIO
                    },
                    onTakePicture = {
                        currentAction.value = CreateIdeaActivityState.TAKING_PICTURE
                    }
                )
            }
            CreateIdeaActivityState.DRAWING -> {
                Back()
                //DrawIdea()
            }
            CreateIdeaActivityState.WRITING -> {
                Back()
                //WriteIdea()
            }
            CreateIdeaActivityState.RECORDING_VIDEO -> {
                Back()
                //RecordVideo()
            }
            CreateIdeaActivityState.RECORDING_AUDIO -> {
                Back()
                RecordAudio()
            }
            CreateIdeaActivityState.TAKING_PICTURE -> {
                Back()
                //TakePicture()
            }
        }
    }
}