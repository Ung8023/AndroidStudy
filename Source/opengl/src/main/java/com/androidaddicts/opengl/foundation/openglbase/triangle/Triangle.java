package com.androidaddicts.opengl.foundation.openglbase.triangle;

/**
 * @author feilang-liuyansong
 * @date 2018/5/8 10:42
 * @description
 */

import android.opengl.GLES30;
import android.opengl.Matrix;

import com.androidaddicts.opengl.foundation.openglbase.ShaderUtil;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/**
 主要功能为初始化定点数据、初始化着色器、设置相应的平移矩阵及旋转矩阵

 */
public class Triangle {

    /**
     * 4*4 投影矩阵
     */
    public static float[] mProjMatrix = new float[16];

    /**
     * 摄影机位置朝向的参数矩阵
     */
    public static float[] mVMatrix = new float[16];

    /**
     * 总的变换矩阵
     */
    public static float[] mMVPMatrix;

    /**
     * 自定义渲染管线着色器程序 id
     */
    int mProgram;

    /**
     * 总变换矩阵引用
     */
    int mMVPMatrixHandle;

    /**
     * 定点位置属性引用
     */
    int mPositionHandle;

    /**
     * 定点颜色属性引用
     */
    int mColorHandle;

    /**
     * 定点着色器代码脚本
     */
    String mVertexShader;
    /**
     * 片着色器代码脚本
     */
    String mFragmentShader;

    /**
     * 具体物体的3D变化矩阵
     */
    static float[] mMMatrix = new float[16];

    /**
     * 顶点坐标数据缓冲
     */
    FloatBuffer mVertexBuffer;

    /**
     * 顶点着色数据缓冲
     */
    FloatBuffer mColorBuffer;

    /**
     * 顶点数量
     */
    int vCount = 0;

    /**
     * 绕x轴宣战的角度
     */
    float xAngle = 0;

    public Triangle(TriangleDisplayView view) {
        // 初始化顶点
        initVertexData();
        // 初始化着色器
        initShader(view);
    }

    /**
     * 初始化顶点
     */
    private void initVertexData() {
        vCount = 3;
        //设置单位长度
        final float UNIT_SIZE = 0.2f;

        //顶点坐标数组
        float[] vertices = new float[]{
                -4 * UNIT_SIZE, 0, 0,
                0, -4 * UNIT_SIZE, 0,
                4 * UNIT_SIZE,0 ,0};

        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(vertices.length * 4);
        //设置字节顺序为本地操作系统顺序
        byteBuffer.order(ByteOrder.nativeOrder());
        // 转换为Float缓冲区
        mVertexBuffer = byteBuffer.asFloatBuffer();
        // 在缓冲区内写入数据
        mVertexBuffer.put(vertices);
        //设置缓冲区起始位置
        mVertexBuffer.position(0);

        //顶点颜色数组
        float[] colors = new float[] {
                1, 1, 1, 0,
                0, 0, 1, 0,
                0, 1, 0, 0
        };
        ByteBuffer colorBuffer = ByteBuffer.allocateDirect(colors.length * 4);
        colorBuffer.order(ByteOrder.nativeOrder());
        mColorBuffer = colorBuffer.asFloatBuffer();
        mColorBuffer.put(colors);
        mColorBuffer.position(0);

    }

    private void initShader(TriangleDisplayView view) {
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
        // 初始化变化矩阵
        Matrix.setRotateM(mMMatrix, 0, 0, 0, 1, 0);
        // 设置沿z轴正向平移
        Matrix.translateM(mMMatrix, 0, 0, 0, 1);
        // 设置绕x轴旋转
        Matrix.rotateM(mMMatrix, 0,  xAngle, 1, 0, 0);
        //将变换矩阵传入渲染管线
        GLES30.glUniformMatrix4fv(mMVPMatrixHandle, 1, false, Triangle.getFinalMatrix(mMMatrix), 0);
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

    public static float[] getFinalMatrix(float[] spec) {
        mMVPMatrix = new float[16];
        Matrix.multiplyMM(mMVPMatrix, 0, mVMatrix, 0, spec, 0);
        Matrix.multiplyMM(mMVPMatrix, 0, mProjMatrix, 0, mMVPMatrix, 0);
        return mMVPMatrix;
    }

}
