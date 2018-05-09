package com.androidaddicts.opengl.foundation.music;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import cn.ung8023.androidstudy.activity.ActivityEntity;
import cn.ung8023.androidstudy.activity.BaseMainActivity;

public class MainMusicActivity extends BaseMainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("音乐相关");
    }

    @Override
    protected List<ActivityEntity> getData() {
        return new ArrayList<ActivityEntity>(){
            {
                add(new ActivityEntity("SoundPool", SoundPoolActivity.class));
                add(new ActivityEntity("音乐播放器", MusicPlayerActivity.class));
            }
        };
    }
}
