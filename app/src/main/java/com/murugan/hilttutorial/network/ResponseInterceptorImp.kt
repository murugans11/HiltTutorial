package com.murugan.hilttutorial.network

import android.util.Log
import com.murugan.hilttutorial.TAG
import javax.inject.Inject

class ResponseInterceptorImp @Inject constructor() : Interceptor {
    override fun log(message: String) {
        Log.d(TAG, "This is Response Interceptor: $message")
    }
}