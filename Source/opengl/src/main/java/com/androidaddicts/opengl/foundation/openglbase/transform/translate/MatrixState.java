package com.androidaddicts.opengl.foundation.openglbase.transform.translate;

import android.opengl.Matrix;

/**
 * @author Ung
 * @date 2018/5/9 14:27
 * @description 管理系统变换矩阵的类
 */

public class MatrixState {
    /**
     *  4 x 4 矩阵，投影用
     */
    private static float[] mProjMatrix = new float[16];

    /**
     * 摄像机位置朝向，9参数矩阵
     */
    private static float[] mVMatrix = new float[16];

    /**
     * 总变换矩阵
     */
    private static float[] mMVPMatrix;

    /**
     * 当前变换矩阵
     */
    private static float[] currentMatrix;
    /**
     * 用于保存变换矩阵的栈
     */
    private static float[][] mStack = new float[10][16];

    /**
     * 栈顶索引
     */
    static int stackTop = -1;

    /**
     * 产生无任何变换的矩阵
     */
    public static void setInitStack() {
        currentMatrix = new float[16];
        Matrix.setRotateM(currentMatrix, 0, 0, 1, 0, 0);
    }

    public static void pushMatrix() {
        stackTop ++;
        for (int i = 0; i < 16; i ++) {
            mStack[stackTop][i] = currentMatrix[i];
        }
    }

    public static void popMatrix() {
        for (int i = 0; i < 16; i ++) {
            currentMatrix[i] = mStack[stackTop][i];
        }

        stackTop --;
    }

    /**
     * 沿x, y, z 平移
     * @param x
     * @param y
     * @param z
     */
    public static void translate(float x, float y, float z) {
        Matrix.translateM(currentMatrix, 0, x, y, z);
    }

    public static void setCamera(
            float cx, float cy, float cz,
            float tx, float ty, float tz,
            float upx, float upy, float upz) {

        Matrix.setLookAtM(mVMatrix,
                    0,
                    cx, cy, cz,
                    tx, ty, tz,
                    upx, upy, upz
                );

    }

    public static void setProjectOrtho(float left, float right,
                                       float bottom, float top,
                                       float near, float far) {
        Matrix.orthoM(mProjMatrix,
                0,
                left, right,
                bottom, top,
                near, far);
    }

    public static void setProjectFrustum(float left, float right,
                                       float bottom, float top,
                                       float near, float far) {
        Matrix.frustumM(mProjMatrix,
                0,
                left, right,
                bottom, top,
                near, far);
    }

    public static float[] getFinalMatrix() {
        mMVPMatrix = new float[16];
        Matrix.multiplyMM(mMVPMatrix, 0, mVMatrix, 0, currentMatrix, 0);
        Matrix.multiplyMM(mMVPMatrix, 0, mProjMatrix, 0, mMVPMatrix, 0);
        return mMVPMatrix;
    }

    public static float[] getMatrix() {
        return currentMatrix;
    }

}
