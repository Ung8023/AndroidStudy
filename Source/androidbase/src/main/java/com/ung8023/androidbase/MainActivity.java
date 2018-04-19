package com.ung8023.androidbase;

import com.ung8023.androidbase.dialog.DialogActivity;
import com.ung8023.androidbase.storage.LocalFileActivity;
import com.ung8023.androidbase.view.ViewActivity;

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
                add(new ActivityEntity("Progress", DialogActivity.class));
                add(new ActivityEntity("View", ViewActivity.class));
            }
        };
    }
}