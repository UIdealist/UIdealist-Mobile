package com.helper.idealist.ui.views

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import com.helper.idealist.R
import com.helper.idealist.ui.texts.Title
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

@Composable
fun Ideas() {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Title(text = stringResource(R.string.title_raw_ideas))
    }
}