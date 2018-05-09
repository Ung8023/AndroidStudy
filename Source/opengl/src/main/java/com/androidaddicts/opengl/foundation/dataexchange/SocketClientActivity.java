package com.androidaddicts.opengl.foundation.dataexchange;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.androidaddicts.opengl.R;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**

 ### C/S模式通信的基本过程：

 (1)首先启动服务器，监听指定端口，等待接收客户端的连接请求。
 (2)客户端请求连接到服务器的指定端口。
 (3)服务器收到客户端的连接请求，建立连接。
 (4)客户端和服务器同时各打开一个输入流和输出流，客户端的输出流与服务器的输入流连接，服务器的输出流与客户端的输入流连接。
 (5)客户端与服务器端通过输入输出流进行双向的消息通信。
 (6)当通信完毕后，客户端和服务器同时关闭本次连接。

 */
public class SocketClientActivity extends AppCompatActivity {

    EditText messageET;

    TextView messageTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_socket_client);
        setTitle("Socket通信");
        initViews();
    }

    private void initViews() {
        messageET = findViewById(R.id.et_message);
        messageTV = findViewById(R.id.tv_message);
    }

    public void connectToServer(View view) {
        new Thread(new Runnable() {

            @Override
            public void run() {
                connectToServer();
            }
        }).start();
    }

    private void connectToServer() {
        String serverIpAddress = "192.168.10.12";
        String message = messageET.getText().toString();

        try {
            Socket socket = new Socket(serverIpAddress, 8877);

            DataInputStream din = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());


            dataOutputStream.writeUTF(message);

            final String data = din.readUTF();
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    messageTV.setText(data);
                }
            });

            din.close();
            dataOutputStream.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
