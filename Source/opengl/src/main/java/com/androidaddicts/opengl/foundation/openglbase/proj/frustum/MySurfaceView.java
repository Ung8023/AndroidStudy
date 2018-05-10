package com.androidaddicts.opengl.foundation.openglbase.proj.frustum;

import android.content.Context;
import android.opengl.GLES30;
import android.opengl.GLSurfaceView;
import android.view.MotionEvent;

import com.androidaddicts.opengl.foundation.openglbase.MatrixState;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/**
 * @date 2018/5/9 14:15
 * @description
 */

public class MySurfaceView extends GLSurfaceView {

    private final float TOUCH_SCALE_FACTOR = 180.0f / 320; // 角度缩放比例

    private SceneRenderer mRenderer;

    private float mPreviousY;
    private float mPreviousX;

    public MySurfaceView(Context context) {
        super(context);
        this.setEGLContextClientVersion(3);

        mRenderer = new SceneRenderer();
        setRenderer(mRenderer);
        setRenderMode(GLSurfaceView.RENDERMODE_CONTINUOUSLY);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float y = event.getY();
        float x = event.getX();

        switch (event.getAction()) {
            case MotionEvent.ACTION_MOVE:
                float dy = y - mPreviousY;
                float dx = x - mPreviousX;

                for (SixPointedStar h: mRenderer.ha) {
                    h.yAngle += dx * TOUCH_SCALE_FACTOR;
                    h.xAngle += dy * TOUCH_SCALE_FACTOR;
                }

                break;
            default:
                break;

        }

        mPreviousX = x;
        mPreviousY = y;

        return true;
    }

    private class SceneRenderer implements Renderer {

        SixPointedStar[] ha=new SixPointedStar[6];

        @Override
        public void onSurfaceCreated(GL10 gl, EGLConfig config) {
            GLES30.glClearColor(0.5f, 0.5f, 0.5f, 1.0f);

            for (int i = 0; i < ha.length; i ++) {
                ha[i] = new SixPointedStar(MySurfaceView.this, 0.4f, 1.0f, -1f * i);
            }

            GLES30.glEnable(GLES30.GL_DEPTH_TEST);
        }

        @Override
        public void onSurfaceChanged(GL10 gl, int width, int height) {
            GLES30.glViewport(0, 0, width, height);

            float ratio = (float) width / height;

            MatrixState.setProjectFrustum(-ratio * 0.4f, ratio * 0.4f, -1 * 0.4f, 1 * 0.4f, 1, 50);

            MatrixState.setCamera(
              0, 0, 6f,
              0, 0, 0f,
              0f, 1.0f, 0.0f
            );
        }

        @Override
        public void onDrawFrame(GL10 gl) {
            GLES30.glClear(GLES30.GL_DEPTH_BUFFER_BIT | GLES30.GL_COLOR_BUFFER_BIT);

            for (SixPointedStar h: ha) {
                h.drawSelf();
            }
        }
    }


}
