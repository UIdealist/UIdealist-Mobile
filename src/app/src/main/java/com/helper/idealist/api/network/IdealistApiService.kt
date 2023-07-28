package com.helper.idealist.api.network

import com.helper.idealist.api.poko.auth.SignIn
import com.helper.idealist.api.poko.auth.SignInResponse
import com.helper.idealist.api.poko.auth.SignUp
import com.helper.idealist.api.poko.auth.SignUpResponse
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST

private fun getHttpClient(): OkHttpClient {
    val okHttpBuilder = OkHttpClient.Builder()
    okHttpBuilder.addInterceptor { chain ->
        val requestWithUserAgent = chain.request().newBuilder()
            .header("User-Agent", "Idealist Client")
            .build()
        chain.proceed(requestWithUserAgent)
    }
    return okHttpBuilder.build()
}

private const val BASE_URL = "http://192.168.1.6:5000"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .client(getHttpClient())
    .addConverterFactory(MoshiConverterFactory.create(moshi).asLenient())
    .build()

interface IdealistService {
    @POST("api/v1/user/sign/in")
    fun signIn(@Body signIn : SignIn) : Call<SignInResponse>

    @POST("api/v1/user/sign/up")
    fun signUp(@Body signUp : SignUp) : Call<SignUpResponse>
}

object IdealistAPI {
    val retrofitService : IdealistService by lazy {
        retrofit.create(IdealistService::class.java)
    }
}