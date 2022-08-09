package com.murugan.hilttutorial.network

import android.util.Log
import com.murugan.hilttutorial.TAG
import javax.inject.Inject

class CallInterceptorImp @Inject constructor() : Interceptor {

    override fun log(message: String) {
        Log.d(TAG, "This is a call Interceptor: $message")
    }
}