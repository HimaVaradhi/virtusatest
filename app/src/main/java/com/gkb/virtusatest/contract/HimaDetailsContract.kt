package com.gkb.virtusatest.contract

import com.gkb.virtusatest.model.HimaDetailsResponse


interface HimaDetailsContract {
    fun onSuccess(list: List<HimaDetailsResponse>)

    fun onFailure(message: String)
}