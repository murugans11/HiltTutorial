package com.murugan.hilttutorial.database

import android.util.Log
import com.murugan.hilttutorial.TAG
import javax.inject.Inject

class DatabaseService @Inject constructor() {

    fun log(message: String) {
        Log.d(TAG, "DatabaseService:$message")
    }

}