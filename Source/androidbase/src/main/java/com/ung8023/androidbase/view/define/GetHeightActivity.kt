package com.ung8023.androidbase.view.define

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import android.widget.LinearLayout
import com.ung8023.androidbase.R

class GetHeightActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_height)

        val linearLayout = findViewById<LinearLayout>(R.id.layout)
        linearLayout.post({
            Log.w("View", "getWith,getHeight,  w = " + linearLayout.width + ", H = " + linearLayout.height )
            Log.w("View", "getMeasuredWidth, getMeasuredHeight,  w = " + linearLayout.measuredWidth + ", H = " + linearLayout.measuredHeight )
            Log.w("View", "LayoutParams, w = " + linearLayout.layoutParams.width + "" +
                    ", h = " + linearLayout.layoutParams.height)
            val childAt = linearLayout.getChildAt(linearLayout.childCount - 1)

            Log.w("view", "h = " + childAt.height)
            Log.w("view", "height:" + (childAt.height + childAt.top + linearLayout.paddingBottom))
        })
        linearLayout.scrollBy(0, 100)
        val ges = GestureDetector(this, object : GestureDetector.OnGestureListener{
            override fun onShowPress(e: MotionEvent?) {
            }

            override fun onSingleTapUp(e: MotionEvent?): Boolean {
                return false
            }

            override fun onDown(e: MotionEvent?): Boolean {
                return true
            }

            override fun onFling(e1: MotionEvent?, e2: MotionEvent?, velocityX: Float, velocityY: Float): Boolean {
                return false
            }

            override fun onScroll(e1: MotionEvent?, e2: MotionEvent?, distanceX: Float, distanceY: Float): Boolean {
                if ((linearLayout.scrollY >= 0 && distanceY > 0) || ((distanceY <= 0) && (linearLayout.scrollY > 0))) {
                    linearLayout.scrollBy(0, distanceY.toInt())
                }

                if (linearLayout.scrollY < 0) {
                    linearLayout.scrollY = 0
                    linearLayout.scrollTo(linearLayout.scrollX, linearLayout.scrollY)
                }
                return false
            }

            override fun onLongPress(e: MotionEvent?) {
            }

        })
        linearLayout.setOnTouchListener(View.OnTouchListener {
            v, event ->
                ges.onTouchEvent(event)
        })
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)

    }
}
