package com.ung8023.androidbase.view

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.ung8023.androidbase.R

class ShapeXmlActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shape_xml)

        val btn = findViewById<Button>(R.id.btn)
        val drawable = resources.getDrawable(R.drawable.btn_shape_xml) as GradientDrawable
        drawable.setColor(resources.getColor(android.R.color.holo_blue_bright))
        btn.background = drawable
    }
}
