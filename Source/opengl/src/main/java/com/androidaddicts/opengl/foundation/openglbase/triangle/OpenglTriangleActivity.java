package com.androidaddicts.opengl.foundation.openglbase.triangle;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class OpenglTriangleActivity extends AppCompatActivity {

    TriangleDisplayView mView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 设置为竖屏模式
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        mView = new TriangleDisplayView(this);
        // 获取焦点
        mView.requestFocus();
        // 设置为可触控
        mView.setFocusableInTouchMode(true);

        setContentView(mView);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mView.onPause();
    }
}
