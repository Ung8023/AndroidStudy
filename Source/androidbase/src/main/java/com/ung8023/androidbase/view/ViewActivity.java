package com.ung8023.androidbase.view;

import com.ung8023.androidbase.dialog.DialogActivity;
import com.ung8023.androidbase.storage.LocalFileActivity;

import java.util.ArrayList;
import java.util.List;

import cn.ung8023.androidstudy.activity.ActivityEntity;
import cn.ung8023.androidstudy.activity.BaseMainActivity;

public class ViewActivity extends BaseMainActivity {

    @Override
    protected List<ActivityEntity> getData() {
        return new ArrayList<ActivityEntity>(){
            {
                add(new ActivityEntity("移除View", RemoveViewActivity.class));
                add(new ActivityEntity("TextView显示链接", TextViewActivity.class));
            }
        };
    }
}