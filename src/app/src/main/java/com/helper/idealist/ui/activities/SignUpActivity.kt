package com.helper.idealist.ui.activities

import android.widget.Toast
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.helper.idealist.R
import com.helper.idealist.api.network.IdealistAPI
import com.helper.idealist.api.poko.auth.SignUp
import com.helper.idealist.api.poko.auth.SignUpResponse
import com.helper.idealist.ui.buttons.MainButton
import com.helper.idealist.ui.buttons.MainButtonType
import com.helper.idealist.ui.inputs.LabeledInput
import com.helper.idealist.ui.texts.Title
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpActivity : ThemedActivity(){

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

    @Composable
    override fun content() {
        val username = remember { mutableStateOf("")}
        val password = remember { mutableStateOf("")}
        val email = remember { mutableStateOf("")}

        Title(text = stringResource(R.string.button_label_sign_up_title))
        Spacer(modifier = Modifier.size(100.dp))

        LabeledInput(
            label = stringResource(R.string.text_input_label_sign_up_user),
            placeholder = stringResource(R.string.text_input_label_sign_up_user_placeholder),
            stateVar = username,
            icon = Icons.Default.Person,
            iconDescription = stringResource(R.string.person_icon_description)
        )

        LabeledInput(
            label = stringResource(R.string.text_input_label_sign_up_password),
            placeholder = stringResource(R.string.text_input_label_sign_up_password_placeholder),
            stateVar = password,
            icon = Icons.Default.Lock,
            iconDescription = stringResource(R.string.lock_icon_description)
        )

        LabeledInput(
            label = stringResource(R.string.text_input_label_sign_up_email),
            placeholder = stringResource(R.string.text_input_label_sign_up_email_placeholder),
            stateVar = email,
            icon = Icons.Default.Email,
            iconDescription = stringResource(R.string.email_icon_description)
        )

        Spacer(modifier = Modifier.size(10.dp))

        MainButton(
            text = stringResource(R.string.button_label_sign_up_main),
            onClick = { submitData(
                username = username.value,
                password = password.value,
                email = email.value
            ) },
            type = MainButtonType.Primary
        )
    }
}