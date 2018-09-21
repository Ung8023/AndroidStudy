package com.ung8023.androidbase.process.binderpool

import android.app.Service
import android.content.Intent
import android.os.IBinder

class BinderPoolService: Service() {

    companion object {
        const val TAG = "BinderPoolService"
    }

    private var mBinderPool = BinderPoolImpl()

    override fun onBind(intent: Intent?): IBinder {
        return mBinderPool
    }


}