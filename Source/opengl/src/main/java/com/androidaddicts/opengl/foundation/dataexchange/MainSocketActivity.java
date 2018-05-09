package com.androidaddicts.opengl.foundation.dataexchange;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import cn.ung8023.androidstudy.activity.ActivityEntity;
import cn.ung8023.androidstudy.activity.BaseMainActivity;

public class MainSocketActivity extends BaseMainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("通信相关");
    }

    @Override
    protected List<ActivityEntity> getData() {
        return new ArrayList<ActivityEntity>(){
            {
                add(new ActivityEntity("SocketClient", SocketClientActivity.class));
                add(new ActivityEntity("蓝牙聊天", BluetoothChatActivity.class));
            }
        };
    }
}
