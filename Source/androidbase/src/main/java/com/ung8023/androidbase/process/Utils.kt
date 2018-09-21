package com.ung8023.androidbase.process

import android.app.ActivityManager
import android.content.Context
import android.os.Process

fun getProcessName(context: Context): String {
    val myPid = Process.myPid()
    val activityManager = context.applicationContext.getSystemService(Context.ACTIVITY_SERVICE) as? ActivityManager
    val process = activityManager?.runningAppProcesses?.filter {
        it.pid == myPid
    }?.firstOrNull()
    return process?.processName?:"can not get process name"
}