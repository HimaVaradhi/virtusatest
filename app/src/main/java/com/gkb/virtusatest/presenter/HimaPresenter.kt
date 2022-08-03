package com.gkb.virtusatest.presenter

import android.annotation.SuppressLint
import com.gkb.virtusatest.model.*
import com.gkb.virtusatest.api.ApiClient
import com.gkb.virtusatest.util.Constants
import com.gkb.virtusatest.views.activities.HimaActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HimaPresenter(private val view: HimaActivity) {
    fun getMyData() {
        ApiClient.getHimaClient.getData()
            .enqueue(object : Callback<List<HimaResponseData>?> {
            @SuppressLint("NotifyDataSetChanged")
            override fun onResponse(
                call: Call<List<HimaResponseData>?>,
                response: Response<List<HimaResponseData>?>
            ) {
                if (response.isSuccessful && response.code() == Constants.RESPONSE_CODE_200) {
                    view!!.onSuccess(response.body()!!)
                }
            }

            override fun onFailure(call: Call<List<HimaResponseData>?>, t: Throwable) {
                view!!.onFailure("Failed")
            }
        })
    }
}



