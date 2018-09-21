package com.ung8023.androidbase.view.text;

import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cn.ung8023.androidstudy.activity.ActivityEntity;
import cn.ung8023.androidstudy.activity.BaseMainActivity;

public class TextViewMainActivity extends BaseMainActivity {

    @Override
    protected List<ActivityEntity> getData() {
        return new ArrayList<ActivityEntity>(){
            {
                add(new ActivityEntity("TextView显示", TextViewUrlActivity.class));
                add(new ActivityEntity("TextView去除上下padding", TextViewWithOutPaddingActivity.class));
            }
        };
    }
}