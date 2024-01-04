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
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.helper.idealist.R
import com.helper.idealist.api.datastore.TokenManager
import com.helper.idealist.api.network.IdealistAPI
import com.helper.idealist.api.poko.auth.SignIn
import com.helper.idealist.api.poko.auth.SignInResponse
import com.helper.idealist.api.poko.auth.SignUp
import com.helper.idealist.api.poko.auth.SignUpResponse
import com.helper.idealist.ui.buttons.MainButton
import com.helper.idealist.ui.buttons.MainButtonType
import com.helper.idealist.ui.inputs.LabeledInput
import com.helper.idealist.ui.texts.Title
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignInActivity : ThemedActivity(){

    fun submitData(
        username : String,
        password : String
    ) {
        // TODO: Validate data prior to submission
        // Create Sign Up Request
        val SignInReq = SignIn(
            username = username,
            password = password
        )

        val call : Call<SignInResponse> = IdealistAPI.retrofitService.signIn(
            SignInReq
        );

        call.enqueue(
            object : Callback<SignInResponse> {
                override fun onFailure(
                    call: Call<SignInResponse?>,
                    t: Throwable
                ){
                    println("**ERROR** " + t.toString())

                    // Make user aware of error
                    Toast.makeText(
                        this@SignInActivity,
                        "Error: " + t.toString(),
                        Toast.LENGTH_LONG
                    ).show()
                }

                override fun onResponse(
                    call: Call<SignInResponse?>,
                    response: Response<SignInResponse?>
                ){
                    if(response.isSuccessful){
                        val signUpResponse = response.body()!!

                        val token = signUpResponse.tokens?.accessToken

                        // Get intent sent from main activity
                        val tokenManager = intent.getSerializableExtra("tokenManager") as TokenManager

                        GlobalScope.launch {
                            tokenManager.saveToken(token!!)
                        }

                        // Make user aware of success
                        Toast.makeText(
                            this@SignInActivity,
                            "Success signing In!",
                            Toast.LENGTH_LONG
                        ).show()

                    } else {

                        println("Error " + response.errorBody()?.string())

                        // Make user aware of error
                        Toast.makeText(
                            this@SignInActivity,
                            "Error: " + response.errorBody()?.string(),
                            Toast.LENGTH_LONG
                        ).show()

                    }
                }
            }
        )
    }

    @Composable
    override fun content() {
        val username = remember { mutableStateOf("") }
        val password = remember { mutableStateOf("") }

        Title(text = stringResource(R.string.button_label_sign_in_title))
        Spacer(modifier = Modifier.size(100.dp))

        LabeledInput(
            label = stringResource(R.string.textinput_label_sign_in_user),
            placeholder = stringResource(R.string.textinput_label_sign_in_user_placeholder),
            stateVar = username,
            color = Color.White
        )

        LabeledInput(
            label = stringResource(R.string.textinput_label_sign_in_password),
            placeholder = stringResource(R.string.textinput_label_sign_in_password_placeholder),
            stateVar = password,
            color = Color.White
        )

        Spacer(modifier = Modifier.size(10.dp))

        MainButton(
            text = stringResource(R.string.button_label_sign_in_main),
            onClick = { submitData(username.value, password.value) },
            type = MainButtonType.Primary
        )
    }
}