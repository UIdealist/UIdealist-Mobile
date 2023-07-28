package com.helper.idealist.ui.activities

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TextField
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.helper.idealist.R
import com.helper.idealist.api.network.IdealistAPI
import com.helper.idealist.api.poko.auth.SignUp
import com.helper.idealist.api.poko.auth.SignUpResponse
import com.helper.idealist.simpleapi.Item
import com.helper.idealist.ui.buttons.MainButton
import com.helper.idealist.ui.inputs.LabeledInput
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpActivity : ComponentActivity(){

    fun submitData(
        username : String,
        password : String,
        email : String
    ) {
        // TODO: Validate data prior to submission
        // Create Sign Up Request
        val SignUpReq = SignUp(
            username = username,
            password = password,
            email = email
        )

        val call : Call<SignUpResponse> = IdealistAPI.retrofitService.signUp(
            SignUpReq
        );

        call.enqueue(
            object : Callback<SignUpResponse> {
                override fun onFailure(
                    call: Call<SignUpResponse?>,
                    t: Throwable
                ){
                    println("**ERROR** " + t.toString())

                    // Make user aware of error
                    Toast.makeText(
                        this@SignUpActivity,
                        "Error: " + t.toString(),
                        Toast.LENGTH_LONG
                    ).show()
                }

                override fun onResponse(
                    call: Call<SignUpResponse?>,
                    response: Response<SignUpResponse?>
                ){
                    if(response.isSuccessful){
                        val signUpResponse = response.body()!!

                        // Make user aware of success
                        Toast.makeText(
                            this@SignUpActivity,
                            "Success signing Up!",
                            Toast.LENGTH_LONG
                        ).show()

                    } else {

                        println("Error " + response.errorBody()?.string())

                        // Make user aware of error
                        Toast.makeText(
                            this@SignUpActivity,
                            "Error: " + response.errorBody()?.string(),
                            Toast.LENGTH_LONG
                        ).show()

                    }
                }
            }
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val username = remember { mutableStateOf("")}
            val password = remember { mutableStateOf("")}
            val email = remember { mutableStateOf("")}

            Column (
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(R.string.button_label_sign_up_title),
                    color = Color.White,
                    fontSize = 60.sp
                )
                Spacer(modifier = Modifier.size(100.dp))

                LabeledInput(
                    label = stringResource(R.string.textinput_label_sign_up_user),
                    placeholder = stringResource(R.string.textinput_label_sign_up_user_placeholder),
                    stateVar = username,
                    color = Color.White
                )

                LabeledInput(
                    label = stringResource(R.string.textinput_label_sign_up_password),
                    placeholder = stringResource(R.string.textinput_label_sign_up_password_placeholder),
                    stateVar = password,
                    color = Color.White
                )

                LabeledInput(
                    label = stringResource(R.string.textinput_label_sign_up_email),
                    placeholder = stringResource(R.string.textinput_label_sign_up_email_placeholder),
                    stateVar = email,
                    color = Color.White
                )

                Spacer(modifier = Modifier.size(10.dp))

                MainButton(
                    text = stringResource(R.string.button_label_sign_up_main),
                    onClick = { submitData(
                        username = username.value,
                        password = password.value,
                        email = email.value
                    ) },
                    type = 3
                )
            }
        }
    }
}