package com.helper.idealist.api.poko.auth

import com.squareup.moshi.Json

data class SignUp (
    @Json(name = "Username") val username : String,
    @Json(name = "Password") val password : String,
    @Json(name = "Email") val email : String
)

data class SignUpResponse (
    val error : Boolean,
    val msg : String?

    // Data can be included as well but is not relevant for our case at all
)