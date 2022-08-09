package com.murugan.hilttutorial

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

const val TAG = "HiltTutorialApplication"

@HiltAndroidApp
class HiltTutorialApplication : Application() {
}