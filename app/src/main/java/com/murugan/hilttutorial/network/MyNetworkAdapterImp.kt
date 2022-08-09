package com.murugan.hilttutorial.network

import android.util.Log
import com.murugan.hilttutorial.TAG
import javax.inject.Inject

class MyNetworkAdapterImp @Inject constructor() : NetworkAdapter {

    override fun log(message: String) {
        Log.d(TAG, "MyNetworkAdapterImp: $message")
    }

}