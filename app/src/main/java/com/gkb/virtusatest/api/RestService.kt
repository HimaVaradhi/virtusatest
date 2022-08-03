package com.gkb.virtusatest.api

import com.gkb.virtusatest.model.*
import retrofit2.Call
import retrofit2.http.*

interface RestService {

    @GET("v1/people")
    fun getData(): Call<List<HimaResponseData>>

    @GET("v1/rooms")
    fun getRoomDetails(): Call<List<HimaDetailsResponse>>

}