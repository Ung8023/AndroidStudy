#version 300 es
// 总变化矩阵
uniform mat4 uMVPMatrix;
// 顶点位置
layout (location = 0) in vec3 aPosition;
// 顶点颜色
layout (location = 1) in vec4 aColor;
// 用于传递给片着色器
out vec4 vColor;
void main() {
    // 根据变化矩阵计算此次绘制此顶点位置
    gl_Position = uMVPMatrix * vec4(aPosition, 1);

    // 将接收的颜色值传递给片元着色器
    vColor = aColor;
}