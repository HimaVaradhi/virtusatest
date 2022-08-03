package com.gkb.virtusatest.api

import com.gkb.virtusatest.util.Constants
import com.gkb.virtusatest.util.Constants.Companion.HIMA_API
import com.gkb.virtusatest.util.Constants.Companion.HIMA_API2
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ApiClient {

    val gson = GsonBuilder()
        .setLenient()
        .create()

    var interceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    private val okHttpClient = OkHttpClient.Builder()
        .connectTimeout(Constants.CONNECTION_TIMEOUT.toLong(), TimeUnit.SECONDS)
        .readTimeout(Constants.READ_TIMEOUT.toLong(), TimeUnit.SECONDS)
        .addInterceptor(interceptor)
        .build()



    val getHimaClient:RestService
    get() {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(HIMA_API)
            .build()
        return retrofit.create(RestService::class.java)
    }

    val getHimaClient2:RestService
        get() {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(HIMA_API2)
                .build()
            return retrofit.create(RestService::class.java)
        }

}