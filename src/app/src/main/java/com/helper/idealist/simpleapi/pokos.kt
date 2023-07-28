package com.helper.idealist.simpleapi

import com.squareup.moshi.Json
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

data class Item(
    @field:Json(name = "status") val status: String?
);

private fun getHttpClient(): OkHttpClient {
    val okHttpBuilder = OkHttpClient.Builder()
    okHttpBuilder.addInterceptor { chain ->
        val requestWithUserAgent = chain.request().newBuilder()
            .header("User-Agent", "Management Helper")
            .build()
        chain.proceed(requestWithUserAgent)
    }
    return okHttpBuilder.build()
}

interface StatusService {
    @GET("/")
    fun getItem(): Call<Item>

    companion object {
        const val API_URL = "http://192.168.1.6:3000"

        fun query() {

            val moshi = Moshi.Builder()
                .add(KotlinJsonAdapterFactory())
                .build()

            val retrofit = Retrofit.Builder()
                .baseUrl(API_URL)
                .client(getHttpClient())
                .addConverterFactory(MoshiConverterFactory.create(moshi).asLenient())
                .build()

            val service = retrofit.create(StatusService::class.java)

            var call : Call<Item> = service.getItem()

            call.enqueue(
                object : Callback<Item> {
                    override fun onFailure( call: Call<Item?>, t: Throwable){
                        println("**ERROR** " + t.toString())
                    }

                    override fun onResponse(call: Call<Item?>, response: Response<Item?>){
                        if(response.isSuccessful){
                            val item = response.body()
                            println(item?.status)
                        } else {
                            println("Error " + response.errorBody()?.string())
                        }
                    }
                }
            )

            //val releases = releaseResponse.body()
        }
    }
}

