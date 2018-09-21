package com.ung8023.androidbase.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.ung8023.androidbase.R

class MultiTouchActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_multi_touch)
    }

    fun click1(view: View) {
        Toast.makeText(this, "1", Toast.LENGTH_SHORT).show()
    }

    fun click2(view: View) {
        Toast.makeText(this, "2", Toast.LENGTH_SHORT).show()
    }
}
