package com.gkb.virtusatest.util

import android.util.Log
import com.gkb.virtusatest.BuildConfig

class Logger {

    companion object {

        private const val TAG = "Logger ==>"

        fun log(message: String, t: Throwable? = null) {
            if (!BuildConfig.BUILD_TYPE.equals("debug")) {
                return
            } else {
                if (t == null) {
                    Log.d(TAG, message)
                } else {
                    Log.d(TAG, message, t)
                    t.printStackTrace()
                }
            }
        }
    }
}