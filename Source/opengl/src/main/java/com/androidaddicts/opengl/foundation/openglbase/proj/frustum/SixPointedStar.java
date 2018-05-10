package com.androidaddicts.opengl.foundation.openglbase.proj.frustum;

import android.opengl.GLES30;
import android.opengl.Matrix;

import com.androidaddicts.opengl.foundation.openglbase.ShaderUtil;
import com.androidaddicts.opengl.foundation.openglbase.MatrixState;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.List;

import static com.androidaddicts.opengl.foundation.openglbase.ShaderUtil.createProgram;

/**
 * @date 2018/5/9 14:24
 * @description
 */

public class SixPointedStar {

    int mProgram;
    int mMVPMatrixHandle;
    int mPositionHandle;
    int mColorHandle;

    String mVertexShader;
    String mFragmentShader;

    static float[] mMMatrix = new float[16];

    FloatBuffer mVertexBuffer;
    FloatBuffer mColorBuffer;
    int vCount = 0;
    float yAngle = 0;
    float xAngle = 0;
    final float UNIT_SIZE = 1;

    public SixPointedStar(MySurfaceView mv, float r, float R, float z) {
        initVertexData(R, r, z);

        initShader(mv);
    }


    public void initVertexData(float R, float r, float z) {
        List<Float> flist = new ArrayList<>();

        float tempAngle = 360/6;

        for(float angle = 0; angle < 360; angle += tempAngle)
        {


            flist.add(0f);
            flist.add(0f);
            flist.add(z);

            flist.add((float)(R * UNIT_SIZE * Math.cos(Math.toRadians(angle))));
            flist.add((float)(R * UNIT_SIZE * Math.sin(Math.toRadians(angle))));
            flist.add(z);

            flist.add((float)(r * UNIT_SIZE * Math.cos(Math.toRadians(angle + tempAngle/2))));
            flist.add((float)(r * UNIT_SIZE * Math.sin(Math.toRadians(angle + tempAngle/2))));
            flist.add(z);

            flist.add(0f);
            flist.add(0f);
            flist.add(z);

            flist.add((float)(r * UNIT_SIZE * Math.cos(Math.toRadians(angle + tempAngle/2))));
            flist.add((float)(r * UNIT_SIZE * Math.sin(Math.toRadians(angle + tempAngle/2))));
            flist.add(z);

            flist.add((float)(R * UNIT_SIZE * Math.cos(Math.toRadians(angle + tempAngle))));
            flist.add((float)(R * UNIT_SIZE * Math.sin(Math.toRadians(angle + tempAngle))));
            flist.add(z);
        }

        vCount = flist.size() / 3;

        float[] vertexArray = new float[flist.size()];

        for(int i=0;i<vCount;i++) {
            vertexArray[i * 3] = flist.get(i * 3);
            vertexArray[i * 3 + 1] = flist.get(i * 3 + 1);
            vertexArray[i * 3 + 2] = flist.get(i * 3 + 2);
        }

        ByteBuffer vbb=ByteBuffer.allocateDirect(vertexArray.length * 4);
        vbb.order(ByteOrder.nativeOrder());
        mVertexBuffer = vbb.asFloatBuffer();
        mVertexBuffer.put(vertexArray);
        mVertexBuffer.position(0);


        float[] colorArray = new float[vCount*4];

        for(int i = 0; i < vCount; i++) {
            if(i%3==0){
                colorArray[i * 4] = 1;
                colorArray[i * 4 + 1] = 1;
                colorArray[i * 4 + 2] = 1;
                colorArray[i * 4 + 3] = 0;
            }
            else{
                colorArray[i * 4] = 0.45f;
                colorArray[i * 4 + 1] = 0.75f;
                colorArray[i * 4 + 2] = 0.75f;
                colorArray[i * 4 + 3] = 0;
            }
        }

        ByteBuffer cbb = ByteBuffer.allocateDirect(colorArray.length * 4);
        cbb.order(ByteOrder.nativeOrder());
        mColorBuffer = cbb.asFloatBuffer();
        mColorBuffer.put(colorArray);
        mColorBuffer.position(0);

    }


    public void initShader(MySurfaceView mv)
    {

        mVertexShader=ShaderUtil.loadFromAssetsFile("vertex.sh", mv.getResources());

        mFragmentShader=ShaderUtil.loadFromAssetsFile("frag.sh", mv.getResources());

        mProgram = createProgram(mVertexShader, mFragmentShader);

        mPositionHandle = GLES30.glGetAttribLocation(mProgram, "aPosition");

        mColorHandle = GLES30.glGetAttribLocation(mProgram, "aColor");

        mMVPMatrixHandle = GLES30.glGetUniformLocation(mProgram, "uMVPMatrix");
    }


    public void drawSelf()
    {

        GLES30.glUseProgram(mProgram);
        // 初始化变换矩阵
        Matrix.setRotateM(mMMatrix, 0, 0, 0, 1, 0);
        // 设置沿z轴正向平移
        Matrix.translateM(mMMatrix, 0, 0, 0, 1);

        Matrix.rotateM(mMMatrix, 0, yAngle, 0, 1, 0);
        Matrix.rotateM(mMMatrix, 0, xAngle, 1, 0, 0);

        // 将变换矩阵传入渲染管线
        GLES30.glUniformMatrix4fv(mMVPMatrixHandle, 1, false, MatrixState.getFinalMatrix(mMMatrix), 0);
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

        //启动顶点位置数据
        GLES30.glEnableVertexAttribArray(mPositionHandle);
        //启用顶点着色数据
        GLES30.glEnableVertexAttribArray(mColorHandle);

        //执行绘制
        GLES30.glDrawArrays(GLES30.GL_TRIANGLES, 0, vCount);
    }
}
