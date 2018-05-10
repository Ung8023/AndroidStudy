package com.androidaddicts.opengl.foundation;


import com.androidaddicts.opengl.foundation.music.MainMusicActivity;
import com.androidaddicts.opengl.foundation.dataexchange.MainSocketActivity;
import com.androidaddicts.opengl.foundation.openglbase.OpenGlBaseActivity;
import com.androidaddicts.opengl.foundation.openglbase.proj.MainProjectionActivity;
import com.androidaddicts.opengl.foundation.openglbase.transform.TransformMainActivity;

import java.util.ArrayList;
import java.util.List;

import cn.ung8023.androidstudy.activity.ActivityEntity;
import cn.ung8023.androidstudy.activity.BaseMainActivity;

public class MainFoundationActivity extends BaseMainActivity {

    @Override
    protected List<ActivityEntity> getData() {
        return new ArrayList<ActivityEntity>() {
            {
                add(new ActivityEntity("游戏音效", MainMusicActivity.class));
                add(new ActivityEntity("Socket连接", MainSocketActivity.class));
                add(new ActivityEntity("OpenGl基础", OpenGlBaseActivity.class));
                add(new ActivityEntity("OpenGl投影", MainProjectionActivity.class));
                add(new ActivityEntity("OpenGl变换", TransformMainActivity.class));
            }
        };
    }
}
