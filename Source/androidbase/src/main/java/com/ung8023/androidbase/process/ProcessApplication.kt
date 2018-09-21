package com.ung8023.androidbase.process

import android.app.Application
import android.util.Log

class ProcessApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        Log.w("ProcessApplication", getProcessName(applicationContext))
        Log.w("Process_ThreadName", Thread.currentThread().name)
    }
}