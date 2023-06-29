package com.helper.managementhelper.network

import com.helper.managementhelper.poko.Rank
import com.helper.managementhelper.poko.RankResponse
import com.helper.managementhelper.poko.auth.SignIn
import com.helper.managementhelper.poko.auth.SignInResponse
import com.helper.managementhelper.poko.auth.SignUp
import com.helper.managementhelper.poko.auth.SignUpResponse
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

private const val BASE_URL = "http://192.168.1.6:5000"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(
        MoshiConverterFactory.create()
    )
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .build()

interface ManagementApiService {
    @POST("api/v1/users/sign/in")
    suspend fun signIn(@Body signIn : SignIn ) : Deferred<Response<SignInResponse>>

    @POST("api/v1/users/sign/in")
    suspend fun signUp(@Body signUp : SignUp ) : SignUpResponse

    @GET("api/v1/users/sign/in")
    suspend fun getRanks() : RankResponse
}

object ManagementApi {
    val retrofitService : ManagementApiService by lazy {
        retrofit.create(ManagementApiService::class.java)
    }
}