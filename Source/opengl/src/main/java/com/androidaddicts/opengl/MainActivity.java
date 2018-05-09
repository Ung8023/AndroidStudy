package com.androidaddicts.opengl;

import com.androidaddicts.opengl.foundation.MainFoundationActivity;

import java.util.ArrayList;
import java.util.List;

import cn.ung8023.androidstudy.activity.ActivityEntity;
import cn.ung8023.androidstudy.activity.BaseMainActivity;

public class MainActivity extends BaseMainActivity {

    @Override
    protected List<ActivityEntity> getData() {
        return new ArrayList<ActivityEntity>(){
            {
                add(new ActivityEntity("OpenGl基础", MainFoundationActivity.class));
            }
        };
    }
}
