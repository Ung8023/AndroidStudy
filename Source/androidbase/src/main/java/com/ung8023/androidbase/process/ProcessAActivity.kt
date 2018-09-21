package com.ung8023.androidbase.process

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.ung8023.androidbase.R

class ProcessAActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_process_a)
        Constants.sNumber = 2
        Log.w("processA", "${Constants.sNumber}")
    }

    fun toB(view: View) {
        startActivity(Intent(this, ProcessBActivity::class.java))
    }
}
