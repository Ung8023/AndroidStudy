package com.androidaddicts.opengl.foundation.openglbase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.androidaddicts.opengl.foundation.openglbase.triangle.OpenglTriangleActivity;

import java.util.ArrayList;
import java.util.List;

import cn.ung8023.androidstudy.activity.ActivityEntity;
import cn.ung8023.androidstudy.activity.BaseMainActivity;

public class OpenGlBaseActivity extends BaseMainActivity {

    @Override
    protected List<ActivityEntity> getData() {
        return new ArrayList<ActivityEntity>() {
            {
                add(new ActivityEntity("旋转3角型", OpenglTriangleActivity.class));
            }
        };
    }
}
