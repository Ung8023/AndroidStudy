package com.androidaddicts.opengl.foundation.openglbase.triangle;

import android.content.Context;
import android.opengl.GLES30;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/**
 * @author feilang-liuyansong
 * @date 2018/5/8 10:40
 * @description
 */

public class TriangleDisplayView extends GLSurfaceView {

    /**
     * 每次三角形旋转的角度
     */
    final float ANGLE_SPAN = 0.375f;

    RotateThread rotateThread;
    SceneRenderer mRenderer;

    public TriangleDisplayView(Context context) {
        super(context);
        // 使用OpenGl 3.0
        this.setEGLContextClientVersion(3);
        mRenderer = new SceneRenderer();
        this.setRenderer(mRenderer);
        this.setRenderMode(GLSurfaceView.RENDERMODE_CONTINUOUSLY);
    }

    private class SceneRenderer implements GLSurfaceView.Renderer {

        Triangle tle;

        @Override
        public void onSurfaceCreated(GL10 gl, EGLConfig config) {
            // 设置屏幕背景色
            GLES30.glClearColor(0, 0, 0, 1.0f);
            tle = new Triangle(TriangleDisplayView.this);

            // 打开深度测试
            GLES30.glEnable(GLES30.GL_DEPTH_TEST);
            rotateThread = new RotateThread();
            rotateThread.start();
        }

        @Override
        public void onSurfaceChanged(GL10 gl, int width, int height) {
            // 设置视口
            GLES30.glViewport(0, 0, width, height);

            // 计算屏幕宽高比
            float ratio = (float) width / height;

            Matrix.frustumM(Triangle.mProjMatrix, 0, -ratio, ratio, -1, 1, 1, 10);
            // 设置相机
            Matrix.setLookAtM(Triangle.mVMatrix, 0, 0, 0, 3, 0f, 0f, 0f, 0f, 1.0f, 0.0f);
        }

        @Override
        public void onDrawFrame(GL10 gl) {
            // 清除颜色缓存和深度缓存
            GLES30.glClear(GLES30.GL_DEPTH_BUFFER_BIT | GLES30.GL_COLOR_BUFFER_BIT);
            tle.drawSelf();
        }
    }

    private class RotateThread extends Thread {
        /**
          设置循环标志位
         */
        public boolean flag = true;

        @Override
        public void run() {
            while (flag) {
                mRenderer.tle.xAngle += ANGLE_SPAN;

                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
