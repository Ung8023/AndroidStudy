package com.ung8023.material

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.CompoundButton
import kotlinx.android.synthetic.main.activity_text_input_layout.*

class TextInputLayoutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text_input_layout)

        cb_c.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener({buttonView, isChecked ->
            if (isChecked) {
                til_aaa.error = "123123"
                til_bbb.error = null
            }else {
                til_aaa.error = null
                til_bbb.error = null
            }

        }))
    }
}
