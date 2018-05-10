package com.androidaddicts.opengl.foundation.openglbase.transform.translate;

import android.opengl.GLES30;
import android.opengl.Matrix;

import com.androidaddicts.opengl.foundation.openglbase.ShaderUtil;
import com.androidaddicts.opengl.foundation.openglbase.triangle.Triangle;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/**
 * @author feilang-liuyansong
 * @date 2018/5/10 09:08
 * @description
 */

public class Cube {
    private int mProgram;
    private int mMVPMatrixHandle;
    private int mPositionHandle;
    private int mColorHandle;

    String mVertexShader;
    String mFragmentShader;

    FloatBuffer mVertexBuffer;
    FloatBuffer mColorBuffer;

    private int vCount;

    public Cube(TranslateView tv) {
        initVertexData();

        initShader(tv);
    }

    private void initVertexData() {
        vCount=12*6;

        float vertices[]=new float[]{

            0,0,Constant.UNIT_SIZE,
            Constant.UNIT_SIZE,Constant.UNIT_SIZE,Constant.UNIT_SIZE,
            -Constant.UNIT_SIZE,Constant.UNIT_SIZE,Constant.UNIT_SIZE,
            0,0,Constant.UNIT_SIZE,
            -Constant.UNIT_SIZE,Constant.UNIT_SIZE,Constant.UNIT_SIZE,
            -Constant.UNIT_SIZE,-Constant.UNIT_SIZE,Constant.UNIT_SIZE,
            0,0,Constant.UNIT_SIZE,
            -Constant.UNIT_SIZE,-Constant.UNIT_SIZE,Constant.UNIT_SIZE,
            Constant.UNIT_SIZE,-Constant.UNIT_SIZE,Constant.UNIT_SIZE,
            0,0,Constant.UNIT_SIZE,
            Constant.UNIT_SIZE,-Constant.UNIT_SIZE,Constant.UNIT_SIZE,
            Constant.UNIT_SIZE,Constant.UNIT_SIZE,Constant.UNIT_SIZE,


            0,0,-Constant.UNIT_SIZE,
            Constant.UNIT_SIZE,Constant.UNIT_SIZE,-Constant.UNIT_SIZE,
            Constant.UNIT_SIZE,-Constant.UNIT_SIZE,-Constant.UNIT_SIZE,
            0,0,-Constant.UNIT_SIZE,
            Constant.UNIT_SIZE,-Constant.UNIT_SIZE,-Constant.UNIT_SIZE,
            -Constant.UNIT_SIZE,-Constant.UNIT_SIZE,-Constant.UNIT_SIZE,
            0,0,-Constant.UNIT_SIZE,
            -Constant.UNIT_SIZE,-Constant.UNIT_SIZE,-Constant.UNIT_SIZE,
            -Constant.UNIT_SIZE,Constant.UNIT_SIZE,-Constant.UNIT_SIZE,
            0,0,-Constant.UNIT_SIZE,
            -Constant.UNIT_SIZE,Constant.UNIT_SIZE,-Constant.UNIT_SIZE,
            Constant.UNIT_SIZE,Constant.UNIT_SIZE,-Constant.UNIT_SIZE,

            -Constant.UNIT_SIZE,0,0,
            -Constant.UNIT_SIZE,Constant.UNIT_SIZE,Constant.UNIT_SIZE,
            -Constant.UNIT_SIZE,Constant.UNIT_SIZE,-Constant.UNIT_SIZE,
            -Constant.UNIT_SIZE,0,0,
            -Constant.UNIT_SIZE,Constant.UNIT_SIZE,-Constant.UNIT_SIZE,
            -Constant.UNIT_SIZE,-Constant.UNIT_SIZE,-Constant.UNIT_SIZE,
            -Constant.UNIT_SIZE,0,0,
            -Constant.UNIT_SIZE,-Constant.UNIT_SIZE,-Constant.UNIT_SIZE,
            -Constant.UNIT_SIZE,-Constant.UNIT_SIZE,Constant.UNIT_SIZE,
            -Constant.UNIT_SIZE,0,0,
            -Constant.UNIT_SIZE,-Constant.UNIT_SIZE,Constant.UNIT_SIZE,
            -Constant.UNIT_SIZE,Constant.UNIT_SIZE,Constant.UNIT_SIZE,

            Constant.UNIT_SIZE,0,0,
            Constant.UNIT_SIZE,Constant.UNIT_SIZE,Constant.UNIT_SIZE,
            Constant.UNIT_SIZE,-Constant.UNIT_SIZE,Constant.UNIT_SIZE,
            Constant.UNIT_SIZE,0,0,
            Constant.UNIT_SIZE,-Constant.UNIT_SIZE,Constant.UNIT_SIZE,
            Constant.UNIT_SIZE,-Constant.UNIT_SIZE,-Constant.UNIT_SIZE,
            Constant.UNIT_SIZE,0,0,
            Constant.UNIT_SIZE,-Constant.UNIT_SIZE,-Constant.UNIT_SIZE,
            Constant.UNIT_SIZE,Constant.UNIT_SIZE,-Constant.UNIT_SIZE,
            Constant.UNIT_SIZE,0,0,
            Constant.UNIT_SIZE,Constant.UNIT_SIZE,-Constant.UNIT_SIZE,
            Constant.UNIT_SIZE,Constant.UNIT_SIZE,Constant.UNIT_SIZE,

            0,Constant.UNIT_SIZE,0,
            Constant.UNIT_SIZE,Constant.UNIT_SIZE,Constant.UNIT_SIZE,
            Constant.UNIT_SIZE,Constant.UNIT_SIZE,-Constant.UNIT_SIZE,
            0,Constant.UNIT_SIZE,0,
            Constant.UNIT_SIZE,Constant.UNIT_SIZE,-Constant.UNIT_SIZE,
            -Constant.UNIT_SIZE,Constant.UNIT_SIZE,-Constant.UNIT_SIZE,
            0,Constant.UNIT_SIZE,0,
            -Constant.UNIT_SIZE,Constant.UNIT_SIZE,-Constant.UNIT_SIZE,
            -Constant.UNIT_SIZE,Constant.UNIT_SIZE,Constant.UNIT_SIZE,
            0,Constant.UNIT_SIZE,0,
            -Constant.UNIT_SIZE,Constant.UNIT_SIZE,Constant.UNIT_SIZE,
            Constant.UNIT_SIZE,Constant.UNIT_SIZE,Constant.UNIT_SIZE,

            0,-Constant.UNIT_SIZE,0,
            Constant.UNIT_SIZE,-Constant.UNIT_SIZE,Constant.UNIT_SIZE,
            -Constant.UNIT_SIZE,-Constant.UNIT_SIZE,Constant.UNIT_SIZE,
            0,-Constant.UNIT_SIZE,0,
            -Constant.UNIT_SIZE,-Constant.UNIT_SIZE,Constant.UNIT_SIZE,
            -Constant.UNIT_SIZE,-Constant.UNIT_SIZE,-Constant.UNIT_SIZE,
            0,-Constant.UNIT_SIZE,0,
            -Constant.UNIT_SIZE,-Constant.UNIT_SIZE,-Constant.UNIT_SIZE,
            Constant.UNIT_SIZE,-Constant.UNIT_SIZE,-Constant.UNIT_SIZE,
            0,-Constant.UNIT_SIZE,0,
            Constant.UNIT_SIZE,-Constant.UNIT_SIZE,-Constant.UNIT_SIZE,
            Constant.UNIT_SIZE,-Constant.UNIT_SIZE,Constant.UNIT_SIZE,
        };

        ByteBuffer vbb = ByteBuffer.allocateDirect(vertices.length * 4);
        vbb.order(ByteOrder.nativeOrder());
        mVertexBuffer = vbb.asFloatBuffer();
        mVertexBuffer.put(vertices);
        mVertexBuffer.position(0);

        float colors[]=new float[]{
                1,1,1,0,
                1,0,0,0,
                1,0,0,0,
                1,1,1,0,
                1,0,0,0,
                1,0,0,0,
                1,1,1,0,
                1,0,0,0,
                1,0,0,0,
                1,1,1,0,
                1,0,0,0,
                1,0,0,0,
                
                1,1,1,0,
                0,0,1,0,
                0,0,1,0,
                1,1,1,0,
                0,0,1,0,
                0,0,1,0,
                1,1,1,0,
                0,0,1,0,
                0,0,1,0,
                1,1,1,0,
                0,0,1,0,
                0,0,1,0,
               
                1,1,1,0,
                1,0,1,0,
                1,0,1,0,
                1,1,1,0,
                1,0,1,0,
                1,0,1,0,
                1,1,1,0,
                1,0,1,0,
                1,0,1,0,
                1,1,1,0,
                1,0,1,0,
                1,0,1,0,
                
                1,1,1,0, 
                1,1,0,0,
                1,1,0,0,
                1,1,1,0, 
                1,1,0,0,
                1,1,0,0,
                1,1,1,0, 
                1,1,0,0,
                1,1,0,0,
                1,1,1,0, 
                1,1,0,0,
                1,1,0,0,

                1,1,1,0, 
                0,1,0,0,
                0,1,0,0,
                1,1,1,0, 
                0,1,0,0,
                0,1,0,0,
                1,1,1,0, 
                0,1,0,0,
                0,1,0,0,
                1,1,1,0, 
                0,1,0,0,
                0,1,0,0,

                1,1,1,0, 
                0,1,1,0,
                0,1,1,0,
                1,1,1,0, 
                0,1,1,0,
                0,1,1,0,
                1,1,1,0, 
                0,1,1,0,
                0,1,1,0,
                1,1,1,0,
                0,1,1,0,
                0,1,1,0,
        };

        ByteBuffer cbb = ByteBuffer.allocateDirect(colors.length * 4);
        cbb.order(ByteOrder.nativeOrder());
        mColorBuffer = cbb.asFloatBuffer();
        mColorBuffer.put(colors);
        mColorBuffer.position(0);
    }

    private void initShader(TranslateView view) {
        //加载顶点着色器的脚本内容
        mVertexShader = ShaderUtil.loadFromAssetsFile("vertex.sh", view.getResources());
        //加载片元着色器的脚本内容
        mFragmentShader = ShaderUtil.loadFromAssetsFile("frag.sh", view.getResources());
        //基于顶点着色器与片元着色器创建程序
        mProgram = ShaderUtil.createProgram(mVertexShader, mFragmentShader);
        //获取程序中顶点位置属性引用 id
        mPositionHandle = GLES30.glGetAttribLocation(mProgram, "aPosition");
        //获取程序中顶点颜色属性引用 id
        mColorHandle= GLES30.glGetAttribLocation(mProgram, "aColor");
        //获取程序中总变换矩阵引用 id
        mMVPMatrixHandle = GLES30.glGetUniformLocation(mProgram, "uMVPMatrix");
    }

    public void drawSelf() {
        // 使用自定义的绘制三角形方法
        GLES30.glUseProgram(mProgram);
        //将变换矩阵传入渲染管线
        GLES30.glUniformMatrix4fv(mMVPMatrixHandle, 1, false, MatrixState.getFinalMatrix(), 0);
        //将顶点位置数据传送进渲染管线
        GLES30.glVertexAttribPointer(
                mPositionHandle,
                3,
                GLES30.GL_FLOAT,
                false,
                3*4,
                mVertexBuffer);

        //将顶点颜色数据传送进渲染管线
        GLES30.glVertexAttribPointer(
                mColorHandle,
                4,
                GLES30.GL_FLOAT,
                false,
                4*4,
                mColorBuffer);

        //启用顶点位置数据
        GLES30.glEnableVertexAttribArray(mPositionHandle);

        //启用顶点着色数据
        GLES30.glEnableVertexAttribArray(mColorHandle);

        //执行绘制
        GLES30.glDrawArrays(GLES30.GL_TRIANGLES, 0, vCount);
    }
}


