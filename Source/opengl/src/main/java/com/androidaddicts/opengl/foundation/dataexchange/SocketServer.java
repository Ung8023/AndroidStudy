package com.androidaddicts.opengl.foundation.dataexchange;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author feilang-liuyansong
 * @date 2018/5/7 11:31
 * @description
 */


public class SocketServer {

    static ServerSocket serverSocket;

    public static void main(String[] args) {
        try {
            serverSocket = new ServerSocket(8877);
            System.out.println("监听8877端口");
            while (true) {
                // 创建Socket对象
                Socket socket = serverSocket.accept();

                DataInputStream diStream = new DataInputStream(socket.getInputStream());

                DataOutputStream doStream = new DataOutputStream(socket.getOutputStream());

                System.out.println("客户端信息： " + diStream.readUTF());

                doStream.writeUTF("成功连接服务器端");
                diStream.close();
                doStream.close();
                socket.close();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
