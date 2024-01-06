package com.helper.idealist.ui.views.mainMenu

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.stringResource
import com.helper.idealist.R
import com.helper.idealist.ui.texts.Title

@Composable
fun Ideas() {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Title(text = stringResource(R.string.title_raw_ideas))
    }
}