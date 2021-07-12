package com.example.compose

import android.app.Application
import android.util.Log
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyApplication: Application() {
    init {
        Log.i("hello", ":compose app ")
    }
}