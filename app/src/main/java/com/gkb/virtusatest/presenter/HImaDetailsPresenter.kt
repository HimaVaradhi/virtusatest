package com.gkb.virtusatest.presenter

import android.annotation.SuppressLint
import com.gkb.virtusatest.model.HimaDetailsResponse
import com.gkb.virtusatest.api.ApiClient
import com.gkb.virtusatest.util.Constants
import com.gkb.virtusatest.views.activities.RoomDetailsActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HImaDetailsPresenter(private val view: RoomDetailsActivity) {

    fun getMyRoomData() {
        ApiClient.getHimaClient2.getRoomDetails()
            .enqueue(object : Callback<List<HimaDetailsResponse>?> {
                @SuppressLint("NotifyDataSetChanged")
                override fun onResponse(
                    call: Call<List<HimaDetailsResponse>?>,
                    response: Response<List<HimaDetailsResponse>?>
                ) {
                    if (response.isSuccessful && response.code() == Constants.RESPONSE_CODE_200) {
                        view!!.onSuccess(response.body()!!)
                    }
                }

                override fun onFailure(call: Call<List<HimaDetailsResponse>?>, t: Throwable) {
                    view!!.onFailure("Failed")
                }
            })
    }
}