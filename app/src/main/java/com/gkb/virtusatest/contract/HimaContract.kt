package com.gkb.virtusatest.contract

import com.gkb.virtusatest.model.HimaResponseData

interface HimaContract {
    fun onSuccess(list: List<HimaResponseData>)

    fun onFailure(message: String)
}