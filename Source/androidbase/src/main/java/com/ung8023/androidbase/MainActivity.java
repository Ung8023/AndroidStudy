package com.ung8023.androidbase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ung8023.androidbase.storage.LocalFileActivity;

import java.util.ArrayList;
import java.util.List;

import cn.ung8023.androidstudy.activity.ActivityEntity;
import cn.ung8023.androidstudy.activity.BaseMainActivity;

public class MainActivity extends BaseMainActivity {

    @Override
    protected List<ActivityEntity> getData() {
        return new ArrayList<ActivityEntity>(){
            {
                add(new ActivityEntity("本地文件存储", LocalFileActivity.class));
            }
        };
    }
}