package com.androidaddicts.opengl.foundation.openglbase;

/**
 * @author feilang-liuyansong
 * @date 2018/5/8 10:09
 * @description
 */

import android.content.res.Resources;
import android.opengl.GLES30;
import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**

 将着色器脚本加载进显卡，并编译。



 */
public class ShaderUtil {
    /**
     * 加载指定着色器
     * @param shaderType
     * @param source
     * @return
     */
    public static int loadShader(int shaderType, String source) {

        //创建着色器
        int shader = GLES30.glCreateShader(shaderType);

        if (shader != 0) {
            GLES30.glShaderSource(shader, source);
            GLES30.glCompileShader(shader);

            int [] compiled = new int[1];
            //获取 Shader 的编译情况
            GLES30.glGetShaderiv(shader, GLES30.GL_COMPILE_STATUS, compiled, 0);
            if (compiled[0] == 0) {
                Log.e("ES30_ERROR", "Could not compile shader" + shaderType + ":");
                Log.e("ES30_ERROR", GLES30.glGetShaderInfoLog(shader));
                GLES30.glDeleteShader(shader);
                shader = 0;
            }
        }

        return shader;
    }

    /**
     * 创建着色器程序
     */
     public static int createProgram(String vertexSource, String fragmentSource) {
         //加载定点点着色器
         int vertexShader = loadShader(GLES30.GL_VERTEX_SHADER, vertexSource);

         if (vertexShader == 0) {
             return 0;
         }

         // 加载片着色器
         int pixelShader = loadShader(GLES30.GL_FRAGMENT_SHADER, fragmentSource);

         if (pixelShader == 0) {
             return 0;
         }

         //创建程序
         int program = GLES30.glCreateProgram();

         if (program != 0) {
             GLES30.glAttachShader(program, vertexShader);
             checkGlError("glAttachShader");

             GLES30.glAttachShader(program, pixelShader);
             checkGlError("glAttachShader");

             // 链接程序
             GLES30.glLinkProgram(program);

             // 存放链接成功program状态值
             int [] linkStatus = new int[1];

             GLES30.glGetProgramiv(program, GLES30.GL_LINK_STATUS, linkStatus, 0);
             if (linkStatus[0] != GLES30.GL_TRUE) {
                 Log.e("ES30_ERROR", "Could not link program :");
                 Log.e("ES30_ERROR", GLES30.glGetProgramInfoLog(program));
                 GLES30.glDeleteProgram(program);
                 program = 0;
             }
         }

         return program;

     }

    /**
     * 检查每一步操作是否有错误
     *
     * checkGlError 方法的作用是在向 GPU 着色程序中加入顶点着色器或者片元着色器时，
     * 检查每一步操作是否有错误。这是由于在开发着色器脚本文件中的代码时，
     * 没有一个开发 环境实时地进行编译、查错
     *
     * @param op
     */
    public static void checkGlError(String op) {
        int error;
        while ((error = GLES30.glGetError()) != GLES30.GL_NO_ERROR) {
            //打印错误
            Log.e("ES30ERROR", op + ": glError " + error);
            //抛出异常
            throw new RuntimeException(op + "glError " + error);
        }
    }

    /**
     * 从sh脚本加载着色器内容
     *
     * checkGlError 方法的作用是在向 GPU 着色程序中加入顶点着色器或者片元着色 器时，
     * 检查每一步操作是否有错误。
     * 这是由于在开发着色器脚本文件中的代码时，没有一个开发环境实时地进行编译、查错
     * @param fName
     * @param resources
     * @return
     */
    public static String loadFromAssetsFile(String fName, Resources resources) {
        String result = null;

        try {
            // 从assets文件夹中读取信息
            InputStream inputStream = resources.getAssets().open(fName);

            int ch = 0;
            ByteArrayOutputStream baos = new ByteArrayOutputStream();

            while ((ch = inputStream.read()) != -1) {
                baos.write(ch);
            }

            byte[] buff = baos.toByteArray();
            baos.close();
            inputStream.close();

            result = new String(buff, "UTF-8");
            result = result.replaceAll("\\r\\n","\n");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }
}
