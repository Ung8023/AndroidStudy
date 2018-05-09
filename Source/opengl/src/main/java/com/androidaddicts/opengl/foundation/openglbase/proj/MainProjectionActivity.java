package com.androidaddicts.opengl.foundation.openglbase.proj;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.androidaddicts.opengl.foundation.openglbase.proj.ortho.OrthogonalProjectionActivity;

import java.util.ArrayList;
import java.util.List;

import cn.ung8023.androidstudy.activity.ActivityEntity;
import cn.ung8023.androidstudy.activity.BaseMainActivity;

public class MainProjectionActivity extends BaseMainActivity {


    @Override
    protected List<ActivityEntity> getData() {
        return new ArrayList<ActivityEntity>() { {
            add(new ActivityEntity("正交投影", OrthogonalProjectionActivity.class));
        }};
    }
}
