#version 300 es
// 设置浮点精度
precision mediump float;

// 接收从顶点着色器过来的参数
in vec4 vColor;
// 输出的片元颜色
out vec4 fragColor;

void main() {
    // 给此片元赋值颜色
    fragColor = vColor;
}