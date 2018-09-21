package com.ung8023.androidbase.process

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.ung8023.androidbase.R


/**
 * 多进程造成的影响：
 * 1. 静态成员和单例模式完全失效
 * 2. 线程同步机制完全实现
 * 3. SharedPreferences可靠性下降
 * 4. Application会多次创建
 */
class ProcessBActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_process_b)
        Log.w("processB", "${Constants.sNumber}")
    }

    fun toA(view: View) {
        startActivity(Intent(this, ProcessAActivity::class.java))
    }
}
