package com.helper.idealist

import android.content.Intent
import androidx.activity.compose.setContent
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.stringResource

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import com.helper.idealist.api.poko.auth.SignUp
import com.helper.idealist.ui.activities.SignInActivity
import com.helper.idealist.ui.activities.SignUpActivity
import com.helper.idealist.ui.buttons.MainButton

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                // Welcome messages
                Text(
                    text = stringResource(R.string.title_welcome_message),
                    modifier = Modifier
                        .background(Color.Transparent),
                    color = Color.White,
                    fontSize = 6.em,
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.size(25.dp))

                Text(
                    text = stringResource(R.string.subtitle_welcome_message),
                    modifier = Modifier
                        .background(Color.Transparent),
                    color = Color.White,
                    fontSize = 4.em,
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.size(100.dp))

                // Buttons to navigate to Sign In and Sign Up activities
                Column (
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    MainButton(
                        text = stringResource(R.string.button_label_sign_in),
                        onClick = {
                            val intent = Intent(this@MainActivity, SignInActivity::class.java)
                            startActivity(intent)
                        },
                        type = 1
                    )

                    MainButton(
                        text = stringResource(R.string.button_label_sign_up),
                        onClick = {
                            val intent = Intent(this@MainActivity, SignUpActivity::class.java)
                            startActivity(intent)
                        },
                        type = 2
                    )
                }
            }
        }
    }
}