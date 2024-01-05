package com.helper.idealist

import android.content.Intent
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.stringResource

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.helper.idealist.ui.activities.MainMenuActivity
import com.helper.idealist.ui.activities.SignInActivity
import com.helper.idealist.ui.activities.SignUpActivity
import com.helper.idealist.ui.activities.ThemedActivity
import com.helper.idealist.ui.buttons.MainButton
import com.helper.idealist.ui.buttons.MainButtonType
import com.helper.idealist.ui.texts.TextCard
import com.helper.idealist.ui.theme.CustomTheme

class MainActivity : ThemedActivity(
    verticalAlign = Arrangement.Top,
) {

    @Composable
    override fun content() {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .background(CustomTheme.colors.primary2)
                    .fillMaxWidth()
                    .padding(
                        top = CustomTheme.spaces.extraLarge,
                        bottom = CustomTheme.spaces.extraLarge
                    )
            ) {
                Text(
                    text = stringResource(R.string.title_welcome_message),
                    style = CustomTheme.typography.h1Cursive,
                    color = CustomTheme.colors.textColor1,
                    textAlign = TextAlign.Center,
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        top = CustomTheme.spaces.extraLarge,
                        bottom = CustomTheme.spaces.extraLarge,
                        start = CustomTheme.spaces.extraSmall,
                        end = CustomTheme.spaces.extraSmall
                    )
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(
                    CustomTheme.spaces.extraLarge
                )
            ) {
                Row{
                    Column{
                        TextCard(
                            text = stringResource(R.string.main_page_message_1),

                        )
                    }
                    Column (
                        modifier = Modifier
                            .fillMaxWidth(0.3f)
                    ){

                    }
                }
                Row{
                    Column(
                        modifier = Modifier
                            .fillMaxWidth(0.3f)
                    ) {

                    }
                    Column{
                        TextCard(
                            text = stringResource(R.string.main_page_message_2)
                        )
                    }
                }
                Row{
                    Column{
                        TextCard(
                            text = stringResource(R.string.main_page_message_3)
                        )
                    }
                    Column(modifier = Modifier
                        .fillMaxWidth(0.3f)
                    ) {

                    }
                }
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(CustomTheme.colors.primary2)
                    .padding(
                        top = CustomTheme.spaces.extraLarge,
                        bottom = CustomTheme.spaces.extraLarge
                    )
                    .wrapContentHeight(
                        align = Alignment.Bottom
                    )
                ,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Row {
                    MainButton(
                        text = stringResource(R.string.button_label_sign_up),
                        onClick = {
                            startActivity(
                                Intent(
                                    this@MainActivity, SignUpActivity::class.java
                                )
                            )
                        },
                        type = MainButtonType.Primary
                    )

                    MainButton(
                        text = stringResource(R.string.button_label_sign_in),
                        onClick = {
                            startActivity(
                                Intent(
                                    this@MainActivity, SignInActivity::class.java
                                )
                            )
                        },
                        type = MainButtonType.Primary
                    )
                }

                Row {
                    MainButton(
                        text = stringResource(R.string.button_label_stay_anonymous),
                        onClick = {
                            startActivity(
                                Intent(
                                    this@MainActivity, MainMenuActivity::class.java
                                )
                            )
                        },
                        type = MainButtonType.Primary
                    )
                }
            }
        }
    }
}