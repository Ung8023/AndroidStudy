package com.ung8023.androidbase.view.scroll;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.TextView;

import com.ung8023.androidbase.R;

public class ViewPropActivity extends AppCompatActivity {

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_prop);

        tv = findViewById(R.id.tv);
        tv.post(new Runnable() {
            @Override
            public void run() {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("x = " + tv.getX() + "\n");
                stringBuffer.append("y = " + tv.getY() + "\n");
                stringBuffer.append("translateX = " + tv.getTranslationX() + "\n");
                stringBuffer.append("translateY = " + tv.getTranslationY() + "\n");

                //  最小滑动距离
                int scaledTapSlop = ViewConfiguration.get(ViewPropActivity.this).getScaledTouchSlop();
                stringBuffer.append("最小滑动距离像素距离: " + scaledTapSlop + "\n");
                tv.setText(stringBuffer);
            }
        });

        tv.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                VelocityTracker velocityTracker = VelocityTracker.obtain();
                velocityTracker.addMovement(event);
                velocityTracker.computeCurrentVelocity(1000);
                int xVelocity = (int)velocityTracker.getXVelocity();
                int yVelocity = (int)velocityTracker.getYVelocity();
                Log.w("速度： ", "x 轴速度: " + xVelocity + ", y 轴速度: " + yVelocity);
                velocityTracker.clear();
                velocityTracker.recycle();
                return true;
            }
        });

        final GestureDetector gestureDetector = new GestureDetector(tv.getContext(), new GestureDetector.OnGestureListener() {
            @Override
            public boolean onDown(MotionEvent e) {
                Log.w("GestureDetector", "onDown");
                return false;
            }

            @Override
            public void onShowPress(MotionEvent e) {
                Log.w("GestureDetector", "onShowPress");
            }

            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                Log.w("GestureDetector", "onSingleTapUp");
                return false;
            }

            @Override
            public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
                Log.w("GestureDetector", "onScroll");
                return false;
            }

            @Override
            public void onLongPress(MotionEvent e) {
                Log.w("GestureDetector", "onLongPress");
            }

            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                Log.w("GestureDetector", "onFling");
                return false;
            }
        });
        gestureDetector.setOnDoubleTapListener(new GestureDetector.OnDoubleTapListener() {
            @Override
            public boolean onSingleTapConfirmed(MotionEvent e) {
                Log.w("GestureDetector", "onSingleTapConfirmed");
                return false;
            }

            @Override
            public boolean onDoubleTap(MotionEvent e) {
                Log.w("GestureDetector", "onDoubleTap");
                return false;
            }

            @Override
            public boolean onDoubleTapEvent(MotionEvent e) {
                Log.w("GestureDetector", "onDoubleTapEvent");
                return false;
            }
        });

        tv.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return gestureDetector.onTouchEvent(event);
            }
        });


    }

    public void leftScroll(View view) {
        ScrollTextView scrollTextView = findViewById(R.id.scrollTv);
        scrollTextView.smoothScrollBy(100, 0);
    }

    public void rightScroll(View view) {
        ScrollTextView scrollTextView = findViewById(R.id.scrollTv);
        scrollTextView.smoothScrollBy(-100, 0);
    }

    public void leftTranslate(View view) {
        ScrollTextView scrollTextView = findViewById(R.id.scrollTv);
        scrollTextView.setTranslationX(100);
    }
    
    public void rightTranslate(View view) {
        ScrollTextView scrollTextView = findViewById(R.id.scrollTv);
        scrollTextView.setTranslationX(-100);
    }
}
