package com.androidaddicts.opengl.foundation.openglbase.transform.translate;


import android.content.pm.ActivityInfo;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.androidaddicts.opengl.foundation.openglbase.OpenglBaseViewActivity;

public class TranslateActivity extends OpenglBaseViewActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    }

    @Override
    protected GLSurfaceView getView() {
        return new TranslateView(this);
    }
}
