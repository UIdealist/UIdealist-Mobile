package com.helper.managementhelper.poko.auth

import com.squareup.moshi.Json

data class SignIn (
    @Json(name = "Username") val username : String,
    @Json(name = "Password") val password : String,
)

data class Tokens (
    @Json(name = "access") val accessToken : String,
    @Json(name = "refresh") val refreshToken : String
)

data class SignInResponse (
    val error : Boolean,
    val msg : String?,
    val tokens: Tokens?
)