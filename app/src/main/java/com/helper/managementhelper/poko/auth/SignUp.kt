package com.helper.managementhelper.poko.auth

import com.squareup.moshi.Json

data class SignUp (
    @Json(name = "Username") val username : String,
    @Json(name = "Password") val password : String,
    @Json(name = "SecretPassword") val secret : String
)

data class SignUpResponse (
    val error : Boolean,
    val msg : String?
)