package com.androidaddicts.opengl.foundation.openglbase.transform.translate;

import android.content.Context;
import android.opengl.GLES30;
import android.opengl.GLSurfaceView;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/**
 * @date 2018/5/10 08:46
 * @description
 */

public class TranslateView extends GLSurfaceView {

    private SceneRenderer mRenderer;

    public TranslateView(Context context) {
        super(context);
        setEGLContextClientVersion(3);

        mRenderer = new SceneRenderer();

        setRenderer(mRenderer);

    }

    private class SceneRenderer implements Renderer {

        Cube cube;

        @Override
        public void onSurfaceCreated(GL10 gl, EGLConfig config) {

            //设置屏幕背景色RGBA
            GLES30.glClearColor(0.5f,0.5f,0.5f, 1.0f);
            cube = new Cube(TranslateView.this); //创建立方体对象
            GLES30.glEnable(GLES30.GL_DEPTH_TEST); //打开深度检测 GLES30.glEnable(GLES30.GL_CULL_FACE); //打开背面剪裁
        }

        @Override
        public void onSurfaceChanged(GL10 gl, int width, int height) {
            //设置视口大小及位置
            GLES30.glViewport(0, 0, width, height);
            //计算视口的宽高比
            Constant.ratio = (float) width / height;

            //调用此方法产生透视投影矩阵
            MatrixState.setProjectFrustum(-Constant.ratio*0.8f, Constant.ratio*1.2f, -1, 1, 20, 100);

            //调用此方法产生摄像机矩阵
            MatrixState.setCamera(-16f, 8f, 45, 0f, 0f, 0f, 0f, 1.0f, 0.0f);

            //初始化变换矩阵
            MatrixState.setInitStack();
        }

        @Override
        public void onDrawFrame(GL10 gl) {

            //清除深度缓冲与颜色缓冲
            GLES30.glClear( GLES30.GL_DEPTH_BUFFER_BIT | GLES30.
                    GL_COLOR_BUFFER_BIT);
            //绘制原立方体
            MatrixState.pushMatrix(); //保护现场
            cube.drawSelf();  //绘制立方体

            MatrixState.popMatrix(); //恢复现场
            // 绘制变换后的立方体
            MatrixState.pushMatrix(); //保护现场
            MatrixState.translate(3.5f, 0, 0);//沿 x 轴方向平移 3.5f
            cube.drawSelf(); //绘制立方体
            MatrixState.popMatrix(); //恢复现场

        }
    }
}

