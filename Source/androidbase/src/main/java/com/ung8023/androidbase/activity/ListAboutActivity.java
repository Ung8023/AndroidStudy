package com.ung8023.androidbase.activity;

import com.ung8023.androidbase.activity.config.ConfigActivity;
import com.ung8023.androidbase.activity.launchmode.BaseLaunchModeActivity;

import java.util.ArrayList;
import java.util.List;

import cn.ung8023.androidstudy.activity.ActivityEntity;
import cn.ung8023.androidstudy.activity.BaseMainActivity;

public class ListAboutActivity extends BaseMainActivity {

    @Override
    protected List<ActivityEntity> getData() {
        return new ArrayList<ActivityEntity>() {
            {
                add(new ActivityEntity("Config变化", ConfigActivity.class));
                add(new ActivityEntity("启动模式", BaseLaunchModeActivity.class));
            }
        };
    }
}
