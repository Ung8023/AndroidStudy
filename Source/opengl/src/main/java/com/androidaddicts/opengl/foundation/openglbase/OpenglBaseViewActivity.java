package com.androidaddicts.opengl.foundation.openglbase;

import android.content.pm.ActivityInfo;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import com.androidaddicts.opengl.foundation.openglbase.proj.frustum.MySurfaceView;

/**
 * @author feilang-liuyansong
 * @date 2018/5/10 08:49
 * @description
 */

public abstract class OpenglBaseViewActivity extends AppCompatActivity {

    GLSurfaceView surfaceView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        this.setTheme(android.support.v7.appcompat.R.style.Theme_AppCompat_NoActionBar);
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        surfaceView = getView();
        setContentView(surfaceView);

        surfaceView.requestFocus();
        surfaceView.setFocusableInTouchMode(true);
    }

    protected abstract GLSurfaceView getView();

    @Override
    protected void onResume() {
        super.onResume();
        surfaceView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        surfaceView.onPause();
    }
}
