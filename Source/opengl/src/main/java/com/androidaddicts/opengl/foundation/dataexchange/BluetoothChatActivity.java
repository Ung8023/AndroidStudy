package com.androidaddicts.opengl.foundation.dataexchange;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.androidaddicts.opengl.R;

/**

 ### 蓝牙设备的使用步骤:

 (1)开启要搜索的设备的蓝牙功能，并设置为可见。
 (2)在一个设备中开启搜索设备的功能，开始搜索设备。
 (3)当搜索到其他设备后，会将搜索的设备显示在本设备的列表中。
 (4)选择列表中的某一设备，请求匹配。
 (5)被选中的设备收到匹配请求后，经双方验证同意，设备匹配成功。
 (6)设备匹配成功后就可以建立连接，并收发数据了。

 */

public class BluetoothChatActivity extends AppCompatActivity {

    private EditText messageET;

    private String connectedNameStr = null;

    private StringBuffer outStringBuffer;

    private BluetoothAdapter mBluetoothAdapter;

    private BluetoothChatService mService;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bluetooth_chat);

        mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
    }

    @Override
    protected void onStart() {
        super.onStart();
        checkBluetooth();
    }

    @Override
    protected synchronized void onResume() {
        super.onResume();
        startService();
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        Intent serverIntent = new Intent(this, BluetoothDeviceListActivity.class);
        startActivityForResult(serverIntent, 1);
        return true;
    }

    private final Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case Constant.MSG_READ:
                    byte[] readBuf = (byte[]) msg.obj;

                    String readMessage = new String(readBuf, 0, msg.arg1);
                    Toast.makeText(BluetoothChatActivity.this,
                            connectedNameStr + ": " + readMessage,
                            Toast.LENGTH_LONG).show();
                    break;
                case Constant.MSG_DEVICE_NAME:
                    connectedNameStr = msg.getData().getString(Constant.DEVICE_NAME);
                    Toast.makeText(BluetoothChatActivity.this,
                            "" + connectedNameStr,
                            Toast.LENGTH_LONG).show();
                    break;
            }
        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case 1:
                    String address = data.getExtras().getString(BluetoothDeviceListActivity.EXTRA_DEVICE_ADDR);
                    BluetoothDevice device = mBluetoothAdapter.getRemoteDevice(address);
                    mService.connect(device);
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mService != null) {
            mService.stop();
        }
    }

    private void startService() {
        if (mService != null && mService.getState() == BluetoothChatService.STATE_NONE) {
            mService.start();
        }
    }

    private void checkBluetooth() {
        if (!mBluetoothAdapter.isEnabled()) {
            Toast.makeText(this, "请打开蓝牙", Toast.LENGTH_LONG).show();
            finish();
        }else {
            if (mService == null) {
                initChat();
            }
        }
    }

    private void initChat() {
        messageET = findViewById(R.id.et_message);
        mService = new BluetoothChatService(this, mHandler);
        outStringBuffer = new StringBuffer("");
    }

    public void send(View view) {
        String outString = messageET.getText().toString();
        sendMessage(outString);
    }

    private void sendMessage(String message) {
        if (mService.getState() != BluetoothChatService.STATE_CONNECTED) {
            Toast.makeText(this, R.string.not_connected, Toast.LENGTH_LONG).show();
            return;
        }

        if (TextUtils.isEmpty(message)) {
            return;
        }

        byte[] bytes = message.getBytes();
        mService.write(bytes);
        outStringBuffer.setLength(0);
        messageET.setText(outStringBuffer);
    }

}
