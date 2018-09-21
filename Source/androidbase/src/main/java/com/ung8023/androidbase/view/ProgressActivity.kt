package com.ung8023.androidbase.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import com.ung8023.androidbase.R
import kotlinx.android.synthetic.main.activity_progress.*
import kotlin.concurrent.timer

class ProgressActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_progress)


        h_timer_progress
    }

    fun start(view: View) {
        h_timer_progress.progress = 0
        val timer = object : CountDownTimer(30000, 1000 ) {
            override fun onFinish() {
            }

            override fun onTick(millisUntilFinished: Long) {
                val total = 30000 - millisUntilFinished
                val progressInt = (total.toFloat() / 300).toInt()
                h_timer_progress.visibility = View.VISIBLE
                h_timer_progress.progress = progressInt
            }
        }
        timer.start()
    }
}
